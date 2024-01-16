# The second half: Collectively editing a program <!-- omit in toc -->

- [Open GitKraken](#open-gitkraken)
- [Creating a branch](#creating-a-branch)
- [Edit the program](#edit-the-program)
- [Commit and Push your branch to GitHub](#commit-and-push-your-branch-to-github)
  - [Commit with GitKraken](#commit-with-gitkraken)
  - [Push with GitKraken](#push-with-gitkraken)
- [Create a pull request to merge your changes into `main`](#create-a-pull-request-to-merge-your-changes-into-main)
  - [Create a pull request](#create-a-pull-request)
  - [You can't merge yet](#you-cant-merge-yet)
    - [Automated checks](#automated-checks)
    - [You might need to merge in changes from `main`](#you-might-need-to-merge-in-changes-from-main)
    - [You need a review](#you-need-a-review)
    - [Review some other pull requests](#review-some-other-pull-requests)
    - [Process the code reviews you receive](#process-the-code-reviews-you-receive)
  - [Finally merge your pull request](#finally-merge-your-pull-request)
- [Huzzah! We're done! :-)](#huzzah-were-done--)

:bangbang: Don't move on to this next part until _everyone_ is done with
the previous part.

:bangbang: You should definitely change _driver_ and _navigator_ roles now.

> :bangbang: :mage_woman: **Faculty**
>
> When the students get this part of the lab, we'll need to
> [turn on branch protections](docs/FACULTY_BRANCH_PROTECTION_SETTINGS.md).
> This will ensure that the checks will be run against
> all pull requests and merging will be blocked if,
> e.g., the tests fail or there aren't enough code
> reviews.

In this second part each group will make a small change to a simple Java
program, `Hellos.java` in the `src/main/java/hellos` directory. Each group will make a
small extension to that program in a way that virtually guarantees some sort
of merge conflict, so everyone will have the experience of dealing with
conflicts.

We'll also introduce the important idea of
[_pull requests_](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/about-pull-requests)
here in this half. A pull request is a GitHub tool that brings together the
changes on a branch into an entity that supports conversations and
[_code review_](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/reviewing-proposed-changes-in-a-pull-request).
Quality code reviews can be a vital part of maintaining and improving
the quality of code in a project, so it's important to seriously engage
in the code review process.

## Open GitKraken

Where we used command line commands to do all the `git` work in the previous
half, in this half we'll use `GitKraken`, which provides a nice GUI and
visualization of things like our commit history and branching.

Open up GitKraken. If this is your first time starting GitKraken it will ask you
to sign in, providing several options. **You want to sign in with your
GitHub account** as this will do two important things:

- It will allow GitKraken to push/pull/etc. to/from GitHub on your behalf.
- [**Assuming you've set up your GitHub Student Pack**](https://education.github.com/pack),
  this will automagically give you a Pro account on GitKraken, which includes
  some nice features that you'll want to have, like an interactive tool
  for resolving merge conflicts. :bangbang: _If you haven't set up your
  GitHub Student Pack, you should do so before setting up GitKraken._

After you've authenticated with GitHub, GitKraken will ask to set up
your `git` info; you should enter your name and whatever email you've used for GitHub.

Once all the setup is finished, select `File -> Open` and navigate to the directory
containing your local clone (`intro-to-git`), and open that up. There's a lot of information
here, but you can ignore most of it for now. One thing that should stand out
is the commit history graph, where you should see all the commits you and all the
other groups made today.

Before we move on, it would be a good idea to do a `git` pull just to make sure
we have the latest version of the code. In GitKraken you can just click the
`Pull` button in the toolbar at the top of the window. If there were recent
changes that you didn't have, the history would update
to show the new commits you just pulled down to your local repository.

![The "pull" button in GitKraken](./docs/images/GitKraken-pull.png)

## Creating a branch

Before we start actually editing the program, we want to introduce
the concept of _branches_ in `git`, which are a powerful tool for
isolating in-progress work
on a particular feature from other on-going work on the project.
Creating and working in your own feature branch allows you to commit,
save, share, and discuss incomplete work without breaking the project for other people.
This is incredibly valuable; without it you'd be constantly worried about
making commits of incomplete work that might mess things up for other people,
or worrying that commits from other people in your group might mess up your
work. If we're serious about [_test driven development_](https://www.agilealliance.org/glossary/tdd/), for example, we would
frequently find ourselves writing and committing tests before we've written
the code that will make those tests pass. If we committed those tests to the
code that everyone was using, then all of a sudden they'd have breaking tests,
the builds would fail, and the _continuous integration_ system would be all
shout-y and mad at the whole team. If, on the other hand, you commit those
tests to your feature branch, then it will have no impact on people
working in other branches, or on the continuous integration system,
so everything will be nice.

Every new `git` repository has one default branch called `main`; this is
usually where the current "deployed" or "released" version of the project
lives, while active development, bug fixes, and the like happen in other
development branches that are merged into `main` when that work is deemed
"done done" (passes the tests, has been through a code review, etc.).

To illustrate the use of branches, we'll have each group create a new branch
for their modification of the shared program. Assuming, for example, that
we still have Pat and Chris, they would create a new branch called something
like `pat-and-chris-greetings`.

In GitKraken we can do this by clicking the `Branch` button in the toolbar
up at the top. It
won't immediately look like anything actually happened, but there will be a
text box to the left of the history diagram where the _HEAD_ (top) of `main` is.

![Creating a new branch in GitKraken](./docs/images/GitKraken-create-a-branch.png)

Enter your branch name (e.g., `pat-and-chris-greetings`) there and hit return. It
should now show (part of) `pat-and-chris-greetings` and a `+1` which indicates
that there's another branch (`main`) whose HEAD is at the same place. You should
also have `pat-and-chris-greetings` listed as a new branch under `LOCAL` in the
explorer on the left, and it should be highlighted to indicate that it is the
currently _checked out_ branch.

![After creating a new branch in GitKraken](./docs/images/GitKraken-with-new-branch.png)

That means that any new commits you make will
be _in that branch_ instead of in `main` as they were in the first half
of this lab.

Here we're creating our branch in GitKraken, but you can do this in the
command line as well. To create and move to a new branch in the command line
you'd use something like

```bash
git switch -c <new_branch_name>
```

This creates the new branch and switches to that branch, so subsequent commits
will happen on that branch. You use
`git switch` without the `-c` to just switch between existing branches;
the `-c` tells `git` that this is a new branch that needs to be created.

## Edit the program

Now that you've created and switched to your new branch, it's time to edit
the program. Before we change anything, though, we should re-run our tests in
VS Code just to make sure everything's still good. While you're there notice
that VS Code automagically noticed that we'd switched to a new branch; down
in the left hand corner of the bottom status bar it should now have the name
of your branch where it used to say `main`.

Open up `Hellos.java` and add some more code to the `generateOutput()`
method:

```java
        builder.append(patSaysHello());
```

Here you'll replace `patSaysHello` with a method name that
reflects the name of the person providing the greeting.
You should create one new method for
_every_ person in your group. If your group is Pat and Chris, then you
want

```java
        builder.append(chrisSaysHello());
        builder.append(patSaysHello());
```

However, instead of just adding them wherever you want, you need to add them so that
everyone's greetings come out in alphabetical order, otherwise the tests won't pass.
So if you started with

```java
        builder.append(kkSaysHello());
        builder.append(nicSaysHello());
```

and you wanted to add Chris and Pat, you'd need to put Chris at the front, and Pat at
the end to maintain alphabetical order:

```java
        builder.append(chrisSaysHello());
        builder.append(kkSaysHello());
        builder.append(nicSaysHello());
        builder.append(patSaysHello());
```

This will create a compiler error because your new methods
(e.g., `patSaysHello`) aren't actually defined anywhere.
So let's fix that, by adding the necessary new methods somewhere down amongst
the example methods; they should look something like:

```java
    private String chrisSaysHello() {
        return "Chris says 'Hello!'\n";
    }
```

Make sure you include the `\n` (newline) in the string so we don't end up
with one really super long line of output. In fact our tests require that
every greeting have the form

```text
   <name> says <greeting>!
```

so make sure you use the word "says" and end the greeting with an exclamation
mark. You can use whatever (polite, class appropriate) greeting you'd like.

You can put your methods wherever you want in the `Hellos` class, but probably
makes sense to have them in the same order as the calls. Our tests don't check
that, though. (They probably can't actually, at least not in any easy way.)

Once everything looks good, compile and run your program to make sure that it works correctly; `./gradlew run` should do the trick.

You should also re-run the tests/checks (`./gradlew check`)
to confirm that all the lines
in the output have the right form and are in alphabetical order.
In general you should always run the tests before you
commit as another way of making sure that your work is "done done".

:bangbang: If you have any problems here, definitely ask questions and get things
working before you proceed; you don't want to merge broken code and mess
things up for everyone else.

If you get stuck there definitely ask questions!

## Commit and Push your branch to GitHub

Now, assuming that your code is all working and happy, let's use GitKraken to
commit and push your work.

### Commit with GitKraken

To commit in GitKraken click the top line in the history graph; its circle
should be empty with a dotted line, and it should have `// WIP` where the
commit summary is.

![GitKraken history graph showing that there's work to commit](docs/images/GitKraken-wip.png)

On the right you should then have panels labelled
"Unstaged Files", "Staged Files", and "Commit Message".

![GitKraken commit interface](docs/images/GitKraken-commit-panels.png)

On the command line you use
`git add` to stage files; in GitKraken you can select a file
in the "Unstaged Files" area and click the "Stage" button that appears next to
the file name. You can also see the changes you've made in that file, which can
be a huge help in forming useful, coherent commit messages.

So stage `Hellos.java`.

Now enter a commit message below that. GitKraken "enforces" the best practice
that your message should have a summary with no more than 72 characters, followed
by a more detailed description of the commit. So you might use a title like

```text
Add greetings for Pat and Chris
```

and a body like

```text
Added a new `patSaysHello()` and `chrisSaysHowdy()` methods, and added calls
to those methods in the correct location in `generateOutput()`.
```

Once you've staged one or more files
and entered a commit message, then you can click the "Commit changes" button on
the bottom right.

That should introduce a new commit to your branch. This should be visible in
the history graph, with your branch branching up from the
HEAD of `main`, with your summary message. (There may be a _lot_ of other branches
because of all the other people creating branches at the same time, but don't
let that freak you out.)

Now we'll push!

### Push with GitKraken

You could do a `pull` before the `push` like we did before, but
(a) you aren't expecting any changes on _your_ branch by another group (so
the `pull` shouldn't bring in any changes) and (b) `push` actually checks
for un-pulled changes and forces you to deal with those if they exist (so it's
safe to just `push` and see what happens).

So hit `Push` in the GitKraken toolbar. It won't look like anything happened,
but there will be a question where the toolbar used to be:

![GitKraken asking what remote branch to use](docs/images/GitKraken-what-remote-branch.png)

The issue here is we created a new _local_ branch, and GitKraken wants to know
what _remote_ repository to connect that to, and with what name. It will default
to `origin` (which in this case is another name for the GitHub repository we
cloned from) and our branch name (e.g., `pat-and-chris-greetings`). Those are
what we want, so hit `Submit`. After a second you should get a bubble in the
bottom left corner says that the `push` was successful.

Assuming the `commit` and `push` worked, if you go to the project web page
on GitHub (and refresh if necessary),
your branch should be in the list of branches, and if you switch to your branch
and go look at `Hellos.java` you should see your changes. Depending on how
many other people have gotten to this point before you, you may see a _lot_
of new branches; these will start to clutter things up, but we can delete
unused branches later.

If you go to the GitHub repo in the web, you should see your branch in the
branch dropdown.

![GitHub branch dropdown menu](docs/images/GitHub-branch-dropdown.png)

If you select it you should see your last commit just below
that. Next to the "Latest commit" label should either be an
orange/yellow dot
(![GitHub's orange in-progress circle][orange-circle]),
a green check mark
(![GitHub's green success check mark][green-check]),
or a red x
(![GitHub's red failure x][red-x])
These show you the build status of that commit.
Every time you (or anyone else) pushes to GitHub, we have GitHub Actions
set up so they run the JUnit tests against that version of the code.
The meaning of these symbols is:

- ![GitHub's orange in-progress circle][orange-circle]:
  The yellow dot means that it's still building and running the tests and checks,
  so we need to be patient.
- ![GitHub's green success check mark][green-check]: A green
  check mark means it's done and everything was great (the code compiled,
  the tests passed, and any other checks passed as well).
- ![GitHub's red failure x][red-x]: A red x means that
  something bad happened, like a test failed.

If you click on any of these symbols on the GitHub page, you can get
more information, including links to pages with details on, e.g., failed tests.

## Create a pull request to merge your changes into `main`

> :information_desk_person: For the next several sections, we'll be doing most
> of the work in GitHub's web interface. Most of this could also be done in GitKraken,
> or even on the command line with some additional tools. We won't
> go over all those other options here in an effort to keep things
> under control, but it's good to know that these things are at least
> possible.

It's cool that your changes are visible in your branch on GitHub, but if
you switch back to `main` on GitHub and look at `Hellos.java`, your code
won't be there. The problem with the current situation is that your nifty
new greetings are "trapped" in the branch you created.
This is sad, because your code is _spectacular_ and really
should be part of the "production" version of the project on the `main`
branch. Right? **Right?**

So you need to merge your branch into `main`.

We don't, however, want to just smash our stuff into `main`. We want to
take advantage of our very clever colleagues and have at least one other
person perform a code review on our proposed changes. A code review is
essentially an online conversation where members of the team build a
shared understanding of these changes, proposing fixes and improvements,
and generally working together to make the code base as amazing as you
collectively can.

### Create a pull request

Go this repo on GitHub (on the web) and there's likely to be one or
more messages in a light yellow box near the top like:

![GitHub button to create a pull request](./docs/images/Create-pull-request-button.png)

If you pushed recently, then one of these messages may will be about your
branch.

- If there is such a message for your branch, click "Compare & pull request".
- If there isn't a message for your branch:
  - Select your branch from the branch dropdown. Then there should be a message
    for your branch.
  - Click "Compare & pull request".

That will bring up the page for creating pull requests, filling in some of the
information based on your commits on that branch. You want to fill in the title
and body of the pull request in a way that describes the goals and actions of
this pull request – what are you trying to accomplish and how did you do it?

When all that's ready, click the green "Create pull request" button to actually
create the pull request.

### You can't merge yet

What you _want_ to do is merge this into `main` so your wonderful changes are
an official part of the project. You can't do it yet, though.

Before you can merge, the following things must be true:

- A set of automated checks have to pass
- Your pull request/branch has to be up-to-date with `main`
- At least two people have to review _and accept_ your pull request

In this example, all the automated checks are passing and the branch is
up-to-date with `main`, but there haven't been any reviews yet.

![GitHub showing checks have passed, but missing reviews](./docs/images/Merging-blocked.png)

#### Automated checks

We use a feature called GitHub Actions to automate a set of checks on the lab
and project repositories in this course. All those checks have to pass before
you can merge in your pull request. For this lab we have several checks:

- "Java / build": This runs `./gradlew check`, which compiles the code
  and runs several checks. If all of these succeed you get a check mark
  (:white_check_mark:), and you get a red x (:x:) if anything fails.
  In particular "Java /build":
  - Runs the JUnit tests and makes sure they pass.
  - Confirms that the test coverage is at least 80%. (This should
    be trivially true as the tests that we've provided should
    automatically cover any new code that's added to `Hellos.java`)
- "markdown-link-check": This checks that all the links in the
  project's Markdown files "work" (i.e., there's something at
  the other end of that URI). You won't be adding or changing any
  links in this lab, so that should continue to pass without any
  concerns.
- "CodeQL / Analyze (java-kotlin)": This triggers quality and security
  checks on our Java code.
- "Check markdown links" makes sure that all the links in the Markdown
  documents in this repository still actually work.

So have a look at the bottom of your pull request and you should see the status of this check. If any of them have an orange/yellow dot next to them,
then that tells you that check is still being processed (e.g., the tests are still
being run) so you'll need to wait a bit for the check to finish. The checks can
take a few minutes, depending on their complexity and how busy the various services
are. :bangbang: That's one of several reasons you should usually run the tests locally before
you push.

If any of the checks fail (give you a red :x:), then you probably want to click on
"Details" by that check to learn more about what might have failed. If the
Java `build` fails, it's likely because a test has
failed, either because you didn't structure your
greeting correctly, or you didn't put it in the correct place so that all
greetings are in alphabetical order. You should probably run the tests again
on your computer, where you'll get more information on which test failed and
why. If you're unsure how to proceed _definitely ask for some help!_

#### You might need to merge in changes from `main`

Another thing that will block merging a pull request is if there have been
changes made to `main` that you don't have in your pull request branch. Consider,
for example, the case where Pat and Chris both create branches from `main`
at about the same time. They both add their greetings, push their work, and
create their pull requests. Let's imagine that (for whatever reason) Pat gets
their changes merged into `main` a little before Chris. Now `main` will have
Pat's changes, but those won't be in Chris's code; this will block Chris from
merging into `main`.

What does that look like on GitHub?

One option is that when Chris looks at their pull request on GitHub they'll
see a message that's something like:

> This branch is out-of-date with the base branch

In that case GitHub can merge the changes from `main` into Chris's branch
automatically. If Chris is OK with that option, they can just press the
"Update branch" button, and GitHub will do that merge.

The more complicated option is when GitHub can't automatically merge the
changes from `main` into Chris's branch, because there's a _merge conflict_.
Merge conflicts happen when two branches both change the same bit of the code,
and `git` isn't able to determine how to combine those changes. If that
happens the message will be something like:

> This branch has conflicts that must be resolved

Here, if Chris clicks the "Resolve conflicts" button, GitHub will put Chris in
a (web) editor where they can resolve the conflicts. That editor will likely
have a section that looks something like:

```diff
 <<<<<<< chris-greeting
    builder.append(chrisSaysHello());
 =======
    builder.append(patSaysHello());
 >>>>>>> main
```

What this rather odd syntax says is that Chris's `chris-greeting` branch has
a line that calls `chrisSaysHello()`, where the `main` branch (which has Pat's
previously committed changes)
has a line that calls `patSaysHello()`. Everything between the `<<<<` line
and the `====` line is what things look like in the `chris-greeting` branch,
and everything between the `====` line and the `>>>>` line are what things
look like in the `main` branch.

There are numerous ways this conflict could have come about, such as:

- Chris wants to change the line from calling `patSaysHello()` to
  instead call the (supposedly different) method `chrisSaysHello()`.
- Chris has renamed `patSaysHello()` to `chrisSaysHello()`, and wants to change
  the call to match this renaming.
- Chris wants to make _both_ function calls.

Here `git` can't tell which of these happened, and thus can't "know" how to
handle the merge. Thus it punts it to us, the human developers, to sort out. Sometimes
it's obvious to us what to do, but sometimes it's really _not_ clear what the
right course of action is. :warning: DO NOT JUST THROW AWAY OTHER PEOPLE'S
WORK TO RESOLVE A MERGE CONFLICT :warning:. This is a place where you really want to
take a moment and contact other people on your team to decide what is the best course
of action.

In this lab, the last option is the most likely situation, and we better call `chrisSaysHello()`
first so that at least those two calls are in alphabetical order.

Chris could use the web editor to make those changes, deleting the `<<<<`, `====`,
and `>>>>` lines, leaving the two calls in the desired order. When things look good,
Chris clicks "Mark as resolved", and then the button to commit the merged changes.

:warning: This is a _very_ simple example of a merge conflict. They can be much more
complex than this, and trickier to resolve. The Pro version of GitKraken (which you
got through the GitHub Student Pack) actually has a very nice GUI for resolving merge
conflicts, and you'd probably rather use that for more complex conflicts.
See [our write-up on using GitKraken to deal with merge conflicts](docs/MERGE_CONFLICTS.md)
for more examples and details.

:bangbang: At this point Chris (or you if you've been doing something
similar) will need to pull these changes back down to your copy if you want
or need to make changes to your branch. The changes you've made by
resolving conflicts in the web GUI _only_ affect the version of the
code on GitHub, so you have to `pull` if you want those changes to be
reflected in your local copy as well. If, for example, Chris realizes here
that the tests are failing because they have the alphabetical order wrong,
they'll need to pull down these changes, fix the alphabetical order, push back
up, and attempt to merge again.

#### You need a review

Now you've finally gotten your code up-to-date and all the checks pass. You
still can't merge because of a red :x: and the message "Review required".
This is because we're following a common "best practice" and requiring at
least two code reviews _by other people_ for each pull request.

So you need to get someone to review your code! In the upper right there's
a "Reviewers" section. Click on the gear there and you should get a drop down
with the (GitHub) names of the other people in the class. Choose two or three
and click their names to invite them to review your code. Don't just choose
the top three – if everyone does that the same few people will be asked to do
_all_ the reviews. Instead, try choosing the two or three names right after yours
on the list – that should spread the load around.

At this point, you can't really do anything until folks have approved your
pull request, so now's a good time to review some other people's pull requests!

#### Review some other pull requests

While you're waiting for feedback from other people, let's do some code reviews
on other people's work. You might have been invited to provide some code reviews;
check your notifications (the bell in the far top right) to see if there are any
code review invitations there. Otherwise you can click on the project's "Pull
requests" tab at the top, and pick any open pull request.

If you had been invited to review this pull request, then there should be a note
to that effect near the top, and a green "Add your review" button which you can
click to start your review.

![GitHub add review button](docs/images/GitHub-add-review.png)

If you haven't been invited, you can just click on the
"Files changed" tab of the pull request, and that will take you to the same place.

![GitHub "Files changed" tab](docs/images/GitHub-files-changed.png)

You'll now be looking at all the changes (old on the left, new on the right).
[There's a _lot_ you can do here](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/reviewing-changes-in-pull-requests/reviewing-proposed-changes-in-a-pull-request),
but for the moment we'll just
look over the code and make sure the changes look reasonable. Some things to
check for:

- [ ] Does it look (by eye) that this will print all the greetings in alphabetical
      order? (The tests check that for sure, but you should always be thinking about
      correctness as well.)
- [ ] Do the new methods they're adding have reasonable names that convey useful
      info to the reader?
- [ ] Are new method names in camel cases, starting in lowercase (the Java standard
  for method names)?
- [ ] Is the implementation of the new methods reasonable?
- [ ] Is the spacing and indentation uniform and consistent with the rest of the file?

Etc., etc.

When you've looked over the code, click the green "Review changes" button on the
top right. From there you can type a comment and decide whether it's just a comment,
or whether you want to accept this pull request or request changes before this
gets merged in. _Don't be shy about requesting changes._ It can seem kind of mean,
and it definitely slows things down, but it can significantly improve the quality
of the overall work, which benefits everyone in the long run.

> :warning: Don't just gloss over their code. It is ultimately up to
_all_ of us to work together to maintain the overall quality of the
work produced by our groups. Part of that is taking code reviews
seriously. It may not seem "nice" to ask for changes to someone's
pull request, but this is the best (and often the only) time for
us to help each other improve the quality of our work. Suggesting
that they fix a misspelling or improve the naming of a method may
seem "minor" and kinda obnoxious, but really that's how we maintain
the quality of our systems over time. So be polite, but also be firm.

#### Process the code reviews you receive

Once you receive a positive review you can proceed to merge. If, however, you
received a request to make some changes, look those over. Does the request make
sense? Do you understand what (and why) it's being made? If not, _definitely_
ask the requestor for further information or explanation. You can post your own comment
on the pull request and/or contact them by other means (e.g., talk to them in person,
or use things like Slack or email). You probably want any important info to be captured
in the pull request, but sometimes it's useful to poke someone on another channel
to get their attention.

While you're waiting for them to re-review your pull request, check and make sure
no one else is waiting for you to re-review code reviews you left on their pull
requests!

### Finally merge your pull request

Let's assume you've _finally_ gotten all the checks to pass, you're up to date
with `main`, and you've gotten the necessary code review approvals. Click the
"Merge when ready" button to tell GitHub that you think everything is good,
and you're ready to merge this code in. You'll then be asked to "Confirm merge
when ready".

If there's something still blocking the merge (a test is failing, or you're
still missing an approval), then GitHub will hold your pull request until everything
is OK. Once that happens, though, your pull request will be added to the
_merge queue_, which is a series of "good to go" pull requests waiting to
be merged into `main`. This process can take a few minutes because GitHub
re-runs all the checks just to make sure things are good, and if there are
several other pull requests ahead of you in the queue it could be a bit.
While you're waiting, do your colleagues a favor and go review some other
pull requests.

Eventually, hopefully, your pull request will get be merged in and your
changes should now
be visible in `main` – your work is officially part of the project! If you
go back to your pull request page, you'll
be given the option to "Delete branch", which will delete your work branch.
Since the changes on that branch are now all merged into `main` it should be
safe to delete that branch. You can, however, leave it there if you prefer and
remove it in some "branch housekeeping" session you run later.

## Huzzah! We're done! :-)

Once everyone has merged their changes to `Hellos.java` into `main` then we're
done with the lab! Well done! :smile:

[orange-circle]: https://icongr.am/octicons/dot-fill.svg?size=16&color=dbab09 "Orange 'in progress' circle"
[green-check]: https://icongr.am/octicons/check.svg?size=16&color=22863a "Green 'success' check mark"
[red-x]: https://icongr.am/octicons/x.svg?size=16&color=cb2431 "Red 'failure' x"
