package dev.ferrandezdaniel.jobandtalentchallenge.ui.features.list

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import dev.ferrandezdaniel.jobandtalentchallenge.R
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.mockk.coEvery
import io.mockk.mockkClass
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class ListFragmentTest {

    companion object {
        internal const val LIST_FRAGMENT_TAG = "LIST_FRAGMENT_TAG"
    }

    private val navControllerListFragment =
        TestNavHostController(ApplicationProvider.getApplicationContext())
    private val viewModel: ListViewModel =
        mockkClass(ListViewModel::class, LIST_FRAGMENT_TAG, relaxed = true)

    @Before("@listFragment")
    fun setUpPreviousTip() {
        loadKoinModules(
            module(true) {
                single { viewModel }
            }
        )
    }

    @After("@listFragment")
    fun tearDownPreviousTip() {
        unloadKoinModules(
            module {
                single { viewModel }
            }
        )
    }

    @Given("^the Restaurant List Fragment with unload restaurants list")
    fun the_restaurants_list_with_loading_data_in_progess() {
        coEvery { viewModel.loadingData.value } returns true
        launchFragmentInContainer(
            Bundle(),
            R.style.Theme_JobAndTalentChallenge
        ) {
            ListFragment().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        navControllerListFragment.setGraph(R.navigation.app_navigation)
                        navControllerListFragment.setCurrentDestination(R.id.listFragment)
                        Navigation.setViewNavController(
                            fragment.requireView(),
                            navControllerListFragment
                        )
                    }
                }
            }
        }
    }

    @When("^restaurant list is not loaded yet")
    fun list_is_empty() {
    }

    @Then("^the progress is shown")
    fun the_progress_is_shown() {
        assertDisplayed(R.id.listRestaurantsProgress)
    }
}
