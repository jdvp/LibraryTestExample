### LibTestingExample
Project to show example of how to run Firebase Test Lab tests for
a library. Typically, since Firebase Test Lab requires 2 separate apk/aab
files for upload, you would be unable to upload the library's aar + test apk.
Further Test Lab also requires that both apk files have different package
names so you can't upload the test apk twice.

This project was created as a sample project for my article
[Android Library UI Tests & Firebase Test Lab](https://jdvp.me/articles/Test-Lab-For-Android-Libraries).

If you fork this project to play around with Test Lab with GitHub Actions, you will need to provide
the following secrets:
* `GCP_PROJECT` - the name of your project on Firebase Test Lab
* `GCP_SA_KEY` - the service account key for you Firebase Test Lab project

Going over how to create these is outside the scope of this project or the associated article, but you
can refer to [this article](https://medium.com/firebase-developers/create-automatic-firestore-backups-with-github-actions-abb12eef86a0)
that mentions how to create these values.
