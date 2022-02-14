# job-and-talent-challenge-android
A Small sample app with a restaurants list and a details view.

The endpoint used to this example is: https://random-data-api.com/api/restaurant/random_restaurant?size=10

##Problems
- Images from api are redirections to https://loremflickr.com/500/500/restaurant. This causes two problems:
  - Several elements into list have the same image.
  - If we want to reload data on details Fragment for any reason, image would be different than the list one because lorenflicker serves a diferrent one every time
    - To solve this I implement a little workaround getting Bitmaps from Url and storing this on UI model, so when we load the list all elements has differents images and in the details Fragment the image is the same than the list element preview.
- Error KaptDebugKotlin: Seems to be a bug on Moshi 1.12.0, I had to research something about and finally I found the solution updating to 1.13.0
