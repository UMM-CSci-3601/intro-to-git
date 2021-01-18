# Branch protection settings for this lab <!-- omit in toc -->

* [Preparing for the first part (before the lab starts)](#preparing-for-the-first-part-before-the-lab-starts)
* [Switching things for the second part](#switching-things-for-the-second-part)

> :mage_woman: This documentation is primarily for the faculty (and
> possibly TAs) running this lab. If it's useful for students, though,
> that's cool.

There are two main parts to this lab:

* The first part, where students just commit new, separate Markdown
  files.
* The second part, where students commit changes to a shared Java file.

## Preparing for the first part (before the lab starts)

In the first part the students commit directly to `main`, and that part
is designed to make it very unlikely that they will have any merge
conflicts. There are also no substantial "checks" that apply to these
Markdown files.

Because they'll be committing directly to `main`, and there are no
meaningful checks, it's important that all branch protections are
_turned off_ (on the copy created by GitHub Classroom in that semester's
organization) before they start the lab.

To check this, go to the GitHub web interface for the (copied) repository
and go to "Settings > Branches". If there's no branch protection rule
for `main` then everything's fine. If there is, however, then you 
need to delete; otherwise no one will be able to directly push to
`main`, which will break lots of things when the students start
going through the lab.

## Switching things for the second part

In the second part, we'll be using pull requests and want branch
protection to be enforcing the checks and code reviews.

So after the first part is all done and before the second part starts,
you'll want to go to "Settings > Branches" and enable branch protection:

* [ ] Click the "Add rule" button
* [ ] Enter `main` in the "Branch name pattern box"

Then go through and check/enable the following options:

* [ ] "Require pull request reviews before merging"
  * [ ] Set the number of required approving reviews to 2
  * [ ] "Dismiss stale pull request approvals when new commits are pushed"
  * [ ] "Restrict who can dismiss pull request reviews"
* [ ] "Require status checks to pass before merging"
  * [ ] "Require branches to be up to date before merging"
  * [ ] Check each of "Better Code Hub", "LGTM analysis: Java", and
        "build" to turn those checks on.

This should prevent anyone from directly committing to `main`, forcing
them to go through pull requests. Those PR will require at least two
code reviews before they can be merged, and all the automated checks
also have to pass.
