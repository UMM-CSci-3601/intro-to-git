# Branch protection settings for this lab <!-- omit in toc -->

- [Preparing for the first part (before the lab starts)](#preparing-for-the-first-part-before-the-lab-starts)
- [Switching things for the second part](#switching-things-for-the-second-part)

> :mage_woman: This documentation is primarily for the faculty (and
> possibly TAs) running this lab. If it's useful for students, though,
> that's cool.

There are two main parts to this lab:

- The first part, where students just commit new, separate Markdown
  files.
- The second part, where students commit changes to a shared Java file.

## Preparing for the first part (before the lab starts)

In the first part the students commit directly to `main`, and that part
is designed to make it very unlikely that they will have any merge
conflicts. There are also no substantial "checks" that apply to these
Markdown files.

Because they'll be committing directly to `main`, and there are no
meaningful checks, it's important that we don't require things like
pull requests and code reviews.

To check this, go to the GitHub web interface for the (copied) repository
and go to "Settings > Branches". If there's no branch protection rule
for `main` then everything's fine. If there is, however, click "Edit"
for that rule and then _uncheck everything_. That will leave some
minimal protection (students won't be able to force push to `main` or
delete the `main` branch), but there won't be any requirements for
pull requests, checks to pass, or code reviews. Requiring things
like pull requests, for example, would break lots of things when
the students start going through the lab.

Since we don't really want students to be able to do things like
delete `main` or
[force push](https://evilmartians.com/chronicles/git-push---force-and-how-to-deal-with-it),
you might want to turn on the minimal protection if
there's nothing there originally. Click "Add rule", enter `main` as
the branch name, and save without checking any of the boxes.

## Switching things for the second part

In the second part, we'll be using pull requests and want branch
protection to be enforcing the checks and code reviews.

So after the first part is all done and before the second part starts,
you'll want to go to "Settings > Branches" and enable branch protection:

- [ ] Click the "Add rule" button
- [ ] Enter `main` in the "Branch name pattern box"

Then go through and check/enable the following options:

- [ ] "Require pull request reviews before merging"
  - [ ] Set the number of required approving reviews to 2
  - [ ] "Dismiss stale pull request approvals when new commits are pushed"
  - [ ] "Restrict who can dismiss pull request reviews"
- [ ] "Require status checks to pass before merging"
  - [ ] "Require branches to be up to date before merging"
- [ ] "Require merge queue"
- [ ] "Do not allow bypassing the above settings"

You also need to add `build` to the set of required checks. Go to the
search box right below "Require branches to be up to date before merging",
search for "build", and select the "build" entry in the resulting
drop-down:

![Finding `build` to add to the status checks](./images/Requiring-build-to-merge.png)

You will have had to have had GitHub Actions run at least once for "build"
to show up in the list. That should have happened multiple times during
part one of the lab, though.

This should prevent anyone from directly committing to `main`, forcing
them to go through pull requests. Those PR will require at least two
code reviews before they can be merged, and all the automated checks
also have to pass.
