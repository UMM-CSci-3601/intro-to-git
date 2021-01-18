# Info on merge conflicts <!-- omit in toc -->

Working as part of a team on a shared repository can be tricky.
If no one else was working on the repository, life would be easy, and
you'd (probably) never have any merge conflicts. But there are other
people working on the repository, and you have to make sure you play
nice with them.

And that can be tricky because other people may have
`push`ed commits up to GitHub, and those commits might conflict with your
changes. Say, for example, Pat and Chris separately notice that someone
(who shall remain unnamed) named a variable `foo`. Chris and Pat both
replace
that content-free name with a more informative name without realizing the
other person was changing the same piece of code. They made different
but reasonable choices: Pat renamed it to `sum` and Chris renamed it
to `total`. If Pat merges the change to `sum` in first, then when Chris
tries to merge in the change to `total`, there will be a merge conflict.
`git` will realize that the commits from both Pat and Chris changed the
same piece of code, but there's no way for `git` to figure out what
the "right" thing to do is, though. So `git` will block the second
merge (from Chris), generate a _merge conflict_, and ask Chris to _resolve_
the conflict by deciding which change to use.

Dealing with merge conflicts, especially complex ones, can be a real headache,
but these tips can help reduce the likelihood of pain here:

* Merge changes into your development branch(es) early and often. The
  more consistent your branch is with `main` (or whatever branch you're going to
  merge into), the less likely conflicts will be, and they'll tend to be smaller
  when they do happen. The history/branch visualization in GitKraken can
  give you a sense of how far your branch is from what's on `main`.
* Break your work into small, manageable stories/tasks/chunks. Small,
  well-defined bits of work tend to touch less code and be completed more
  quickly, both of which reduce the likelihood of a nasty conflict surprise
  when you come to merge.
* Give yourself plenty of time to merge into `main`. You don't want to decide
  you're going to merge into `main` at 2am or 15 minutes before Food Service
  closes for dinner; if there's an unexpected conflict you don't have the
  time and energy to deal with it properly and your chances are much higher that
  you'll do something you'll regret.
* Don't do (big) merges alone (or at least make sure other folks are around).
  This relates to the previous one. If you're caught off guard by a conflict,
  and you're in a hurry, and there's no one around to help you understand how
  your changes relate to and will affect changes other people have made,
  Badness is very likely to ensue.

---

> :warning: The text below follows a different workflow than the workflow based
> on pull requests outlined in the README. You probably want to use that workflow
> when possible, but we've kept this here for now in case it's a useful reference.

The basic process you'll typically want to follow is:

* Make sure all your changes on your feature branch are committed locally.
  * In GitKraken if there's no `WIP` entry at the top then you know all your changes are
    committed. If there is an `WIP` entry, you can click on it to see what's
    not yet committed. (There can be times where you have changes you don't
    yet want to commit, but these can interfere with the process. Feel free
    to create a _stash_ as a way to temporarily store those changes so you
    can get them back later.)
  * Or use `git status` on the command line to confirm that everything you
    mean to have committed is in fact committed.
* Checkout the `main` branch
  * Double click on `main` in the branch listing on the left-hand side
    of GitKraken.
  * Or `git checkout main` on the command line

At this point you should be on the `main` branch, and all your work
on your new contact info page should "disappear" in VS Code. Don't worry, it's still
there in your feature branch, but it's not part of `main` so it's not
visible when we have `main` checked out.

The trick is that this is _your_ copy of the `main` branch, which is
probably out of date with `main` on GitHub (`origin/main`) since
other people have been committing and pushing changes. So you should
first make sure to `pull` any changes other people have made into your
copy:

* The `Pull` button in GitKraken,
* Or `git pull` on the command line

Assuming you've _only_ made changes to your group's special development
branch, this `pull` should succeed with no difficulties, and `git` will
merge in whatever changes other people have `push`ed up to `main` on
GitHub into your copy of `main`. You might want to re-run the tests in
VS Code, though, just to make sure someone hasn't broken things.

Now we have the moment of truth, where you merge your changes from your
development branch (`pat_and_chris_greeting` in our example) into your
newly updated copy of `main`.

* In GitKraken, drag the label with the branch name that you want to merge
  (e.g., `pat-and-chris-greetings`) onto the branch you want to merge into
  (in this case `main`). That will bring up a dialog with several options.
  Go with the first one (probably "Fast-forward", but possible "Merge").
* On the command line `git merge <branch_name>` will merge the changes in
  the specified branch onto whatever branch is currently checked out (`main`)
  in this case.

If you're lucky, any changes you've made won't conflict
with changes other people have made and the merge will succeed immediately.
That likely won't be the case here,
as the changes other groups have made to the program (or changes we made
while you were working on the first part of the lab) will almost certainly
conflict with your work.

Dealing with these kinds of merge conflicts can be a frustrating
experience, but GitKraken has a nice GUI merge conflict tool that makes
it a little easier. The merge tools in VS Code are also quite nice; we'll describe
VS Code here, but you should feel free to use whichever you find most useful.

The sequence of events in GitKraken is likely to look something like:

* The attempt to `merge` will lead to a conflict; you'll have a message like
  "A file conflict was found when attempting to merge" up at the top of the
  commit history graph.
* All the files with merge conflicts will be listed in the "Conflicted Files"
  panel on the right hand side.
* Select a file with a conflict. That should bring up a GUI for resolving
  merge conflicts with one version (`main` in this case) on the top left,
  the version were trying to merge in (e.g., `pat-and-chris-greetings`) on
  the top right, and the `Output` (the result of the merge) at the bottom.
* You can then choose sections (using the checkboxes) that you want to include
  in the finished result. You can even choose to include (or not include)
  individual lines if you wish.
* When you're done click `Save`.
* That will move that file to "Staged Files", and you can move on to a
  commit like normal.

When that's all done then the merge conflict will be _resolved_ in `git`
terminology and you'll be (nearly) read to `push` your changes.

Before you do that, however, you should carefully
proofread any code that's modified in resolving a merge conflict, though,
as it's easy to introduce mistakes in that process.
You'll want to make sure you re-run the test suite, for example, to make
sure that resolving the merge conflict didn't inadvertently break something.

Once that's all happy, though, you should `push` your copy of `main`
up to GitHub.

Normally this should just work because you did a pull on `main` just
a few minutes ago. Occasionally, however, someone will manage to sneak
in a pushed change between your `pull` and `push`, and that's actually
pretty likely today with so many people working in parallel on the same
file. If that happens you'll get some sort of error saying that
your attempt to push `main` was rejected, and suggesting that you pull
or merge remote changes before you push.

So `pull` again, resolve any conflicts (including running the tests, etc.),
and try to `push` again. Because so many groups are modifying the same
file at the same time, it's entirely possible that this could take several
rounds before you get your changes pushed, but it will eventually happen.

When your `push` eventually works, and you should be able to look at the
repository on GitHub and see the changes you made to `Hellos.java` on the
`main` branch of the repository, presumably along with numerous changes
made by other groups. Check that the build is still successful (green check mark)
and raise an alarm if it's not. (:bangbang: It's **never** a good thing
if your build on `main` is breaking, and everyone should stop what they're
doing to try to fix it when it does break.)
