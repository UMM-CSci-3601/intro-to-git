# Introduction to `git`

This will be an in-lab exercise where we'll experience several of the
key features of the `git` version control system, and the Github
repository hosting service. We'll provide command line means of accomplishing
the various tasks in this lab, and will also provide info on how to
accomplishing things using IntelliJ's IDEA software development tools since
IDEA is what we'll be'll using this semester. There's nothing magic about
IDEA here, and almost any reasonable software editor or development environment
provides similar support for `git` commands.

:bangbang: While in most labs it will be fine for groups to move ahead
at their own pace, in this lab we'd like people to keep together
because there are moments where we're expecting certain things to
happen (e.g., merge conflicts) and we want everyone to be in roughly
the same place when that happens.

This definitely will _not_ provide a comprehensive overview of the
_many_ features `git` provides. There are a lot of on-line resources
that can provide additional information, including:

* The excellent [Atlassian `git` tutorials](https://www.atlassian.com/git/tutorials/what-is-version-control)
* A very nice [on-line tutorial from Code School](https://try.github.io/levels/1/challenges/1)
* [The "standard" `git` documentation site](https://git-scm.com/documentation),
which also includes links to videos, cheat sheets, and such
* [`git` – the simple guide](http://rogerdudler.github.io/git-guide/),
a single-page app that goes through the major features of `git`
* [The original blog post on the Gitflow branching model](http://nvie.com/posts/a-successful-git-branching-model/)
(and [a later post arguing that GitFlow is a Very Bad Idea](http://endoflineblog.com/gitflow-considered-harmful))
* [Git Essential Training](https://www.lynda.com/Git-tutorials/Git-Essential-Training/100222-2.html),
an on-line Lynda.com course; it's free if you first authenticate
with your U of M credentials via http://lynda.umn.edu
* [A nice IntelliJ video on the different between _merging_ commits and _rebasing_ commits](https://www.youtube.com/watch?v=Nftif2ynvdA)

We also made [a screencast that
walks through many of the key steps
in this lab](https://www.youtube.com/watch?v=Am6xSrPVX98).
You might find it useful
to watch that before lab, especially if you find videos like that helpful.

The discussion below assumes that people are paired up in the lab, but we want
to make sure everyone has hands on experience with these tools and ideas.
This sort of _pair programming_ will be common throughout the class and
beyond, with two people working together. It is common in these settings for
one person (the _driver_, say Pat) to be at the keyboard, while the other person (the
_navigator_, say Chris) is actively engaged in working with Pat, suggesting ideas, noticing typos,
and answering questions. For this process to work, both of you have to
contribute and be involved, and it's extremely important for you to trade
off the roles of driver and navigator now and then. Thus in this lab
there will be times where we'll explicitly ask you to trade roles so that everyone has a chance to go through all the activities.

# How we're going to use `git`

`git` is a piece of software provides distributed version control, allowing
a team of developers to work together on a project, helping manage
collaboration and change. `git` organizes projects into _repositories_,
which are collections of files and histories of all the changes ever made
to that project. _Github_ is a web-based software service that allows people
to host, search, and use repositories created and managed with `git`. You
could use `git` without ever using Github. Github is an extremely popular
repository hosting service, and it's a good idea for computing folks to be
familiar with it. We use it to manage
[all the labs for this course](https://github.com/UMM-CSci-3601), and you'll
use Github to manage all your labs and project iterations in this course.

When you use `git` and Github, you typically have a single "primary" copy
of your repository hosted on Github; this will be visible to everyone in
your group (and the world if the project is public),
and will be the "copy of record". People will transmit changes through that
copy, and use Github tools like _issues_, _pull requests_, and _code reviews_
to discuss potential changes.

Each developer then has one or more private copies of the repository
(called _clones_) that they make local changes to. They can pull changes
from the Github repository into their local repository, as well as push
local changes up to the Github repository so that other people can access them.

# `clone` a local copy of the repository

Before we can start working on the lab proper, each group will need to
`clone` the Github repository so they have a local copy to work with. There
will only be one copy of the repository on Github, but each group should obtain
a clone on whatever lab machine they're working on, so there will be lots of
local copies. Each of those local copies will be completely independent, and
will only share changes through explicit interactions with the Github
repository through git.

## To `clone` the respository using command line tools you'd do:

```bash
git clone <url>
```

where `<url>` is the URL for the Github repository. You can get these URLs
from the `Clone or download` button visible on a repository on Github.
The URL should look like this:

```
https://github.com/UMM-CSci-3601/intro-to-git.git
```

## To `clone` from within IDEA, if you're at the IDEA "Welcome" dialog, you can choose

```
Check out from Version Control -> Github
```

Login using your github username and password and press Login.
Enter the Repository URL and then open the cloned project in IDEA.
### If you are not at the "Welcome" dialog, another way is to go to

```
File -> New -> Project from Version Control -> GitHub
```

# Create an info page for each pair

Now that we've cloned a local copy of the repository, we can start making
and sharing changes.

This repository has a `user_info` directory, and in this part of the
lab we'll create a new file in that directory for each pair in the
class containing your real names and your Github user names. Sometimes
it's easy for us to figure out how those names relate, but if your
Gihub user name is `UnicornWizard375` it's not always obvious who in the
class that is, especially if you don't wear your wizarding regalia to lab.

There will be several steps to this process, each of which is described in
more detail below:

* Create your contact info file/page
* `commit` that to your local copy of the repository
* `pull` down the changes other people may have made to the central repository on Github while you were working, `merging` them with your changes
* `push` your (merged) changes back up to Github so they're available to everyone

## Creating a page

You'll start by creating your group's contact info page. Each contact
info page should:

* Be named `<your_names>.md`, e.g., `Pat_and_Chris.md`
* Contain at least:
   * Each of your names as you preferred to be called
   * Your preferred pronouns
   * Your Github usernames (so we can figure out who `UnicornWizard375`
   is in real life)

:bangbang: If you create the new file with IDEA it's likely to
ask you if you want to add it to the set of files that were being
tracked by `git`. If that happens say "Yes" to simplify things later,
although it's not a big deal if you say "No".

## `commit` your changes (locally)

Before you can share your changes with the class via the Github repository,
you need to `add` and `commit` these changes to your local `git` repository.

Before you `commit` you have to use `git add` to _stage_ files for the commit.
You might think `git` should just commit any and all changes you've made
since the last commit. That's actually not a great default behavior, though,
because sometimes you've made changes to several files and you'd like to
commit them separately; with the right tools you can even commit different
changes to the same file in separate commits. This is useful because it makes
it easier to have a commit message that is specific to the particular changes
being committed (instead of a generic "changed a bunch of stuff" message that
you often get when there have been a lot of changes). Perhaps more importantly,
though, separate commits allows you to do things like _cherry pick_ individual
commits as things you want to move from one place to another; that's a little
complex for this lab, but know that it's out there as an option. All of this
is why `git` allows you to specify through staging exactly what you wish to
include in a commit.

* Stage the new file so `git` knows you want to commit it
   * `git add <filename>` on the command line
   * `VCS -> Git -> Add` in IDEA (although if you used IDEA to
   create the file, it probably asked you if you wanted to add it to
   the set of files that were being tracked by `git`, so you may not
   need to explicitly add it)
* Commit the change _to your local copy of the repository_
   * `git commit` on the command line.
      * This will bring up a (command line) editor for you to enter
      your commit message. By default this is `vi/vim` for most people;
      ask for help if you find yourself trapped in `vim` and can't seem
      to escape.
      * You can also use `git commit -m "Your cool commit message"` to
      avoid being sent to an editor. We _strongly_ discourage this,
      however, as people rarely enter useful one-line commit messages.
      * If `vi/vim` bugs you, you should probably set your default
      `git` editor to something you like. [This Github help page](https://help.github.com/articles/associating-text-editors-with-git/)
       shows you how to set various GUI editors like `atom`, but you
       could also use something like `git config --global core.editor nano`
       to set it to a command line editor like `nano`.
   * `VCS -> Commit Changes…` in IDEA. This gives you a nice
    dialogue where you can select which files you actually
    want to include in this commit. This is useful because you may have
    made a few changes that are related to different issues – this dialogue
    makes it easier to comment separately on unrelated changes, increasing
    the value of your commits and commit messages. You can also use the
    `Diff` tool in that dialogue to remind yourself of what all you've changed,
    which makes it easier to write
    [informative, complete commit messages](http://chris.beams.io/posts/git-commit/).

## `push`ing your work to Github

At this point you have your changes committed to your local copy of the
repository, and want to _push_ those changes up to the Github copy of the
repository. This is the potentially tricky part, but in this case things
should be well behaved. :smile:

The major issue is that other people may have made and `push`ed changes up
to Github that could potentially conflict with the changes you've made.
So your first step is to `pull` down any recent changes from Github:

* `git pull` on the command line
* `VCS -> Git -> Pull…` in IDEA

If no one else is working on these files in this repository (which is
likely in this case since you created a group-specific file for your
information) then this should go smoothly. As we'll see below, though,
if there have been changes in the same parts of the same files, a `pull`
can lead to conflicts and confusion.

Assuming that your `pull` works, then it's time to _push_ your
work up to the Github repository:

* `git push` on the command line
* `VCS -> Git -> Push…` in IDEA

This will push all your commits up to Github; if you refresh your view of
the Github repository
you should see your new file along with your contact info, probably along
with a lot of other files.

You're now done with the first major part of the lab!

# Editing a simple program

:bangbang: Don't move on to this next part until _everyone_ is done with
the previous part.

In this second part each group will make a small change to a simple Java
program, `Hellos.java` in the `program` directory. Each group will make a
small extension to that program in a way that virtually guarantees some sort
of merge conflict, so everyone will have the experience of dealing with
conflicts.

## Creating a branch

Before we get started on actually editing the program, we want to introduce
the concept of _branches_ in `git`, as they are a powerful tool for
isolating work (in progress)
on a particular feature from other on-going work on the project.
Creating and working in your own feature branch allows you to commit,
save, and share incomplete work without breaking the project for other people.
This is incredibly valuable; without it you'd be constantly worried about
making commits of incomplete work that might mess things up for other people,
or worrying that commits from other people in your group might mess up your
work. If we're serious about _test driven development_, for example, we would
frequently find ourselves writing and committing tests before we've written
the code that will make those tests pass. If we committed those tests to the
code that everyone was using, then all of a sudden they'd have breaking tests,
the builds would fail, and the _continuous integration_ system would be all
shout-y and mad at the whole team. If, on the other hand, you commit those
tests to your development branch, then it will have no impact on people
working in other branches or on the build system, so everything will be
nice.

Every new `git` repository has one default branch called `master`; this is
usually where the current "deployed" or "released" version of the project
lives, while active development, bug fixes, and the like happen in other
development branches that are merged into `master` when that work is deemed
"done done" (passes the tests, has been through a code review, etc.).

To illustrate the use of branches, we'll have each group create a new branch
for their modification of the shared program. Assuming, for example, that
we still have Pat and Chris, they would create a new branch called something like `pat_and_chris_greeting`.

In the command line this would be accomplished with

```bash
git checkout -b <new_branch_name>
```

so they might use `git checkout -b pat_and_chris_greeting` to create the
branch for setting up their group's info.

In IntelliJ IDEA, you can accomplish this through the

```
VCS -> Git -> Branches…
```

dialogue, choosing the `New Branch` option.

Both of these create the new branch and perform a `checkout` on that branch.
The `checkout` part of the process tells `git` to "switch over" to that new
branch, so subsequent commits will happen on that branch. You use
`git checkout` without the `-b` to just switch between existing branches;
the `-b` tells `git` that this is a new branch that needs to be created. In
IDEA you can switch between branches using `VCS -> Git -> Branches…` or
the popup menu from the `Git: <branch>` button on the bottom right of the
GUI.

## Edit the program

Now that you've created and switched to your new branch, it's time to edit
the program. Open up `Hellos.java` and add another line in the `main()`
method of the form

```java
builder.append(pat_and_chris_say_hello());
```

where you replace `pat_and_chris_say_hello` with a method name that
reflects the names in your group.

This will create a compiler error because your new method
(`pat_and_chris_say_hello` in our example) isn't actually defined anywhere.
So let's fix that, by adding a new method somewhere down amongst the example
methods; it should look something like:

```java
    private static String pat_and_chris_say_hello() {
        return "Pat and Chris say 'Hello!'\n";
    }
```

(Make sure you include the `\n` (newline) in the string so we don't end up
with one really super long line.)

Once everything looks good, compile and run your program to make sure that
everything is good before you commit your changes. In IDEA, you can
right-click in the `Hellos.java` window and select `Run 'Hellos.main()'`;
this will make sure everything compiles, and if it does it will run your
program display the output in the `Run` pane at the bottom of the GUI.
You should see the results of our sample greetings along with your new
greeting from your team.
If you have any problems here, definitely ask questions and get things
working before you proceed; you don't want to merge broken code and mess
things up for everyone else.

## Commit and Push your branch to Github

Now assuming that your code is all working and happy, let's use the same
commands as before to

* `commit` your work
* `push` those changes to Github

You could do a `pull` before the `push` like we did before, but
(a) you aren't expecting any changes on _your_ branch by another group (so
the `pull` shouldn't bring in any changes) and (b) `push` actually checks
for unpulled changes and forces you to deal with those if they exist (so it's
safe to just `push` and see what happens).

Assuming the `commit` and `push` worked, if you go to the project web page
on Github (and refresh if necessary),
your branch should be in the list of branches, and if you switch to your branch
and go look at `Hellos.java` you should see your changes. Depending on how
many other groups have gotten to this point before you, you may see a _lot_
of new branches; these will start to clutter things up, but we can delete
unused branches later.

## Merging your branch into `master`

It's cool that your changes are visible in your branch on Github, but if
you switch back to `master` on Github and look at `Hellos.java`, your code
won't be there. The problem with the current situation is that your nifty
new contact info document is "trapped" in the branch you created.
This is sad, because your code is _spectacular_ and really
should be part of the "production" version of the project on the `master`
branch. Right? **Right?**

So you need to merge your branch into `master`.

If no one else was working on this repository it would be easy, and all
you'd need to do is _merge_ into `master` and then _push_ your work up
to the Github repository. But there are other people working on the
repository, and you have to make sure you play nice with them.

And that can be tricky because other people may have
`push`ed commits up to Github, and those commits might conflict with your
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

* `pull` changes into your development branch(es) early and often. The
more consistent your branch is with `master` (or whatever branch you're going to
merge into), the less likely conflicts will be, and they'll tend to be smaller
when they do happen.
* Break your work into small, manageable stories/tasks/chunks. Small,
well-defined bits of work tend to touch less code and be completed more
quickly, both of which reduce the likelihood of a nasty conflict surprise
when you come to merge.
* Give yourself plenty of time to merge into `master`. You don't want to decide
you're going to merge into `master` at 2am or 15 minutes before Food Service
closes for dinner; if there's an unexpected conflict you don't have the
time and energy to deal with it properly and your chances go way up that
you'll do something you'll regret.
* Don't do (big) merges alone (or at least make sure other folks are around).
This relates to the previous one. If you're caught off guard by a conflict,
and you're in a hurry, and there's no one around to help you understand how
your changes relate to and will affect changes other people have made,
Badness is very likely to ensue.

The basic process you'll typically want to follow is:

* Make sure all your changes on your feature branch are committed locally.
   * Use `git status` on the command line to confirm that everything you
   mean to have committed is in fact committed.
   * Use "Local Changes" tab in the "Version Control" window to do the
   same in IDEA
* Checkout the `master` branch
   * `git checkout master` on the command line
   * `VCS -> Git -> Branches…` in IDEA, and then choose `master ->
   origin/master` followed by `Checkout`

At this point you should be on the `master` branch, and all your work
on your new contact info page should "disappear". Don't worry, it's still
there in your feature branch, but it's not part of `master` so it's not
visible when we have `master` checked out.

The trick is that this is _your_ copy of the `master` branch, which is
probably out of date with `master` on Github (`origin/master`) since
other people have been committing and pushing changes. So you should
first make sure to `pull` any changes other people have made into your
copy:

* `git pull` on the command line
* `VCS -> Git -> Pull…` in IDEA

Assuming you've _only_ made changes to your group's special development
branch, this `pull` should succeed with no difficulties, and `git` will
merge in whatever changes other people have `push`ed up to `master` on
Github into your copy of `master`.

Now we have the moment of truth, where you merge your changes from your
development branch (`pat_and_chris_greeting` in our example) into your
newly updated copy of `master`.

* On the command line `git merge <branch_name>` will merge the changes in
the specified branch onto whatever branch is currently checked out (`master`)
in this case.
* In IDEA `VCS -> Git -> Merge Changes…` brings up a "Merge Branches" dialog.
This shows your current branch (which should be `master`) and lets you select
one or more branches you'd like to merge onto `master`. You should select
your group's development branch. You can leave everything else alone, and
then click the "Merge" button.

If you're lucky, any changes you've made won't conflict
with changes other people have made. That likely won't be the case here,
as the changes other groups have made to the program (or changes we made
while you were working on the first part of the lab) will almost certainly
conflict with your work.

Dealing with these kinds of merge conflicts can be a frustrating
experience, but IDEA has a nice GUI merge conflict tool that makes
it a little easier. The sequence of events (in IDEA) is likely to
look something like:

* The attempt to `merge` will be rejected.
* The "Files Merged With Conflicts" dialogue that tells you this will list
all files that had conflicts, and give you the options to "Accept Yours",
"Accept Theirs", or "Merge". You _rarely_ want to just accept yours or theirs,
as that throws away either your work or theirs. So click "Merge".
* That brings up a dialogue with the original version of the document
in the middle pane, and your version and the version with the conflicting
changes in the left and right panes. You can use the `>>`/`<<` symbols
to copy changes from the left or right pane into the result.
If at any point you end up with 
something icky, you can click the "Abort" button and try again.
You can also directly edit the middle pane to tweak the results. When
you're happy with your work, click "Apply".

When that's all done then the merge conflict will be _resolved_ in `git`
terminology. You will, however, need to `commit` those changes into your
`master` branch with `git commit` or `VCS -> Git -> Commit…` as before.

You should carefully
proofread any code that's modified in resolving a merge conflict before
`commit`ting, though, as it's easy to introduce mistakes in that process.
You'll want to make sure you re-run the test suite, for example, to make
sure that resolving the merge conflict didn't inadvertently break something.

Now that your copy of `master` has your work on it, you want to push
that up to Github:

* `git push` on the command line
* `VCS -> Git -> Push…` in IDEA

Normally this should just work because you did a pull on `master` just
a few minutes ago. Occasionally, however, someone will manage to sneak
in a pushed change between your `pull` and `push`, and that's actually
pretty likely today with so many people working in parallel on the same
file. If that happens you'll get some sort of error saying that
your attempt to push `master` was rejected, and suggesting that you pull
or merge remote changes before you push. IDEA lets you do this from
the error dialogue – if you click the `Merge` button IDEA will pull
down the changes from Github and merge them into your `master`.
At that point you would try to `push` again, repeating the pull/merge
step yet again if someone has once again snuck in on you.

Eventually your `push` will work, and you should be able to look at the
repository on Github and see the changes you made to `Hellos.java` on the
`master` branch of the repository, presumably along with numerous changes
made by other groups.

# Huzzah! We're done!

Once everyone has added their changes to `Hellos.java` then we're
done with the lab! Well done! :smile:
