# Introduction to `git`

!["Broken" badge to remind us to fix the URLs on the "real" badges](https://img.shields.io/badge/FIX_BADGES-Badges_below_need_to_be_updated-red)

:bangbang: Each semester _after creating the instance in GitHub Classroom_, 
we need to fix (in the GitHub Classroom "fork") the URLs in the badges
below so they point to that semester's repository instead of the
"master" repo. Then remove this note and the broken badge above in
the fork. (We should leave this in the copy in the "master"
repository so it's there each semester when we fork this.)

![Continuous integration status](https://github.com/UMM-CSci-3601/intro-to-git/workflows/Java%20CI/badge.svg)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/UMM-CSci-3601/intro-to-git.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/UMM-CSci-3601/intro-to-git/alerts/)

- [Introduction to `git`](#introduction-to-git)
  - [Background](#background)
    - [How we're going to use `git`](#how-were-going-to-use-git)
    - [Configuring your `git` e-mail](#configuring-your-git-e-mail)
  - [The first half: Adding our names](#the-first-half-adding-our-names)
    - [`clone` a local copy of the repository](#clone-a-local-copy-of-the-repository)
      - [Join our GitHub Classroom team; get your clone URL](#join-our-github-classroom-team-get-your-clone-url)
      - [Command line `clone`](#command-line-clone)
    - [Using `gradle` to run tasks](#using-gradle-to-run-tasks)
    - [Opening our project in VS Code](#opening-our-project-in-vs-code)
    - [Create an info page for each pair](#create-an-info-page-for-each-pair)
      - [Creating a page](#creating-a-page)
      - [`commit` your changes (locally)](#commit-your-changes-locally)
      - [`push`ing your work to GitHub](#pushing-your-work-to-github)
  - [The second half: Collectively editing a program](#the-second-half-collectively-editing-a-program)
    - [Open GitKraken](#open-gitkraken)
    - [Creating a branch](#creating-a-branch)
    - [Edit the program](#edit-the-program)
    - [Commit and Push your branch to GitHub](#commit-and-push-your-branch-to-github)
      - [Commit with GitKraken](#commit-with-gitkraken)
      - [Push with GitKraken](#push-with-gitkraken)
    - [Merging your branch into `master`](#merging-your-branch-into-master)
  - [Huzzah! We're done! :-)](#huzzah-were-done)

## Background

This is an in-lab exercise where we'll introduce and practice several of the
key features of [the `git` version control system](https://git-scm.com/),
and [the GitHub repository hosting service](https://github.com/).
We'll provide command line means of accomplishing
the various tasks in the first part of this lab. For the second part of the lab, we'll
provide info on how to use [GitKraken](https://www.gitkraken.com/git-client) along with
[Visual Studio Code (VS Code)](https://code.visualstudio.com/) since
those tools will be part of our primary workflow this semester. `git` is essentially
a command line tool, and it can be difficult to visualize branching and history;
GitKraken provides a nice GUI for `git` which we find it quite helpful for understanding
what's going on. VS Code is our IDE (basically our fancy program editor); there are lots
of alternatives, but we're going to use VS Code this semester.

:bangbang: While in most labs it will be fine for groups to move ahead
at their own pace, in this lab we'd like people to keep together
because there are moments where we're expecting certain things to
happen (e.g., merge conflicts) and we want everyone to be in roughly
the same place when that happens.

This definitely will _not_ provide a comprehensive overview of the
_many_ features `git` provides. There are a lot of on-line resources
that can provide additional information, including:

- [The GitKraken tutorial videos](https://www.gitkraken.com/learn-git)
- The excellent [Atlassian `git` tutorials](https://www.atlassian.com/git/tutorials/what-is-version-control)
- [The "standard" `git` documentation site](https://git-scm.com/documentation),
which also includes links to videos, cheat sheets, and such
- [`git` – the simple guide](http://rogerdudler.github.io/git-guide/),
a single-page app that goes through the major features of `git`
- Several on-line courses on `git` from Lynda.com; it's free if you first authenticate with your U of M credentials via <http://lynda.umn.edu>
  - [Git Essential Training: The Basics](https://www.lynda.com/Git-tutorials/Git-Essential-Training-Basics-REVISION-2019-Q1/5030978-2.html)
  - [Git: Branches, Merges, and Remotes](https://www.lynda.com/Git-tutorials/Git-Branches-Merges-Remotes/5030980-2.html)
  - [Git for Teams](https://www.lynda.com/Git-tutorials/Git-Teams/711821-2.html)
- [A little on-line "game" for learning how branching works in `git`](https://learngitbranching.js.org/)

As circunstances allow, you might also want to at least skim one or two of the
tutorials listed above.

We'll also be using _Gradle_, a tool for building and running programs. We'll be
using Gradle throughout the course, so it's useful to see it a bit here. We also
use it to automate the tests for this project, which allows GitHub Actions to
automatically run our tests whenever someone makes a change, and holler at us if
someone breaks the tests.

The discussion below assumes that people are paired up in the lab, but we want
to make sure everyone has hands on experience with these tools and ideas.
This sort of _pair programming_ will be common throughout the class and
beyond, with two people working together. It is common in these settings for
one person (the _driver_, say Pat) to be at the keyboard, while the other person (the
_navigator_, say Chris) is actively engaged in working with Pat, suggesting ideas, noticing typos,
and answering questions. For this process to work, both of you have to
contribute and be involved, and it's extremely important for you to trade
off the roles of driver and navigator now and then. Thus in this lab
there will be times where we'll explicitly ask you to trade roles so that
everyone has a chance to go through all the activities.

### How we're going to use `git`

`git` is a piece of software which provides distributed version control, allowing
a team of developers to work together on a project, helping manage
collaboration and change. We're going to use three related tools:

- `git` is the fundamental program (developed to help manage the Linux
  operating system codebase) that underlies the next two tools. It
  organizes projects into _repositories_, which are collections of files and
  histories of all the changes ever made to that project. It is a command
  line tool.
- GitKraken is a GUI for `git` that provides a nice visual interface to `git`
  and display of complex things like `git` histories and branching.
- _GitHub_ is a web-based software service that allows people
  to host, search, and use repositories created and managed with `git`.
  
You could use `git` without ever using GitKraken or GitHub. We've found that a
good GUI like GitKraken can be a big help when things get complicated. GitHub
is an extremely popular repository hosting service, and it's a good idea for
computing folks to be familiar with it. We use it to manage
[all the labs for this course](https://github.com/UMM-CSci-3601), and you'll
use GitHub to manage all your labs and project iterations in this course.

This lab essentially has two halves:

- Adding your names in separate Markdown files
- Adding your greetings in the Java code

We'll use command line `git` for the first half so you have some exposure to
using `git` on the command line. This is important because you don't always
have GUIs for things if, for example, you're remotely logged into some cloud
server. We'll then use GitKraken in the second half, also mentioning how you'd
accomplish some of the new `git` tasks on the command line.

When you use `git` and GitHub, you typically have a single "primary" copy
of your repository hosted on GitHub; this will be visible to everyone in
your group (and the world if the project is public),
and will be the "copy of record". People will transmit changes through that
copy, and use GitHub tools like _issues_, _pull requests_, and _code reviews_
to discuss potential changes.

Each developer then has one or more private copies of the repository
(called _clones_) that they make local changes to. They can pull changes
from the GitHub repository into their local repository, as well as push
local changes up to the GitHub repository so that other people can access them.

### Configuring your `git` e-mail

Before we actually start to _use_ `git`, you should [configure your `git`
email so work you do in our lab properly connects to your GitHub
account](https://help.github.com/articles/setting-your-commit-email-address-in-git/).
You only need to do this once and it will "stick" throughout the lab
in all systems that use `git`.

- Open a terminal window
- Type `git config --global user.email "email@example.com"` where
  you replace `email@example.com` with the email you used to set up
  your GitHub account.
- Verify that it worked by typing `git config --global user.email`;
  you should get the address you just configured as the response.

If you want to use a different e-mail address than the one you
signed up for GitHub with (e.g., you signed up with a non-U
email but you'd like to use your UMM email now) you can
[set your commit email address on GitHub](https://help.github.com/articles/setting-your-commit-email-address-on-github/)
so that they match.

If you'll be using any non-lab machines (like your own computer)
to do work, make sure you [set your `git` email](https://help.github.com/articles/setting-your-commit-email-address-in-git/)
on those machines as well. This will ensure that no matter where
you commit from, `git` and GitHub will "know" it's you and properly
credit you for your work.

## The first half: Adding our names

In this part of the lab we'll add everyone's names and GitHub usernames to the
repository so we'll be able to figure out who GitHub user `MightyWombat259`
is in real life.

### `clone` a local copy of the repository

Before we can start working on the lab proper, each group will need to
`clone` the GitHub repository so they have a local copy to work with. There
will only be one copy of the repository on GitHub, but each group should obtain
a clone on whatever lab machine they're working on, so there will be lots of
local copies. Each of those local copies will be completely independent, and
will only share changes through explicit interactions with the GitHub
repository through git.

#### Join our GitHub Classroom team; get your clone URL

We'll be using GitHub Classroom all semester to manage team repositories.
For each project we'll post a GitHub Classroom URL on the assignment on Canvas;
you'll use that to create/join your team for that lab. GitHub Classroom
will create a _fork_ (essentially a copy on GitHub for your team) of our starter
repository that your team will use as the starting part for your work.

This lab is unusual in that we will all be on a single large team called
__Everyone__, all making changes to a single shared repository. This will
help illustrate the value of version control systems like `git` in managing
this kind of shared resource, and also give us opportunities to see what
happens when different people make inconsistent changes to the same files.

So follow the link in the Canvas assignment and join the __Everyone__ team;
that should take you to the shared repository on GitHub. From there
you can get the URL for that repository
from the `Clone or download` button visible on the "home page" for each
repository on GitHub.
See [GitHub's "Cloning a repository" tutorial](https://help.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository)
for examples. The URL should look like this:

```
https://github.com/YOUR-ORG-OR-NAME/REPO.git
```

where `YOUR-ORG-OR-NAME` is the a user name or (in our case) an organization name
and `REPO` is the name of the repository.

#### Command line `clone`

We'll make our local clones via the command line, so open a terminal (or just the one
from before if it's still open). Go to whatever directory seems appropriate. Then to
`clone` the respository using command line tools you'd do:

```bash
git clone <url>
```

where you replace `<url>` with the URL for the GitHub repository.

### Using `gradle` to run tasks

We're using the `gradle` build tool in our labs. We're not going to talk a lot about
Gradle here, but see [our Gradle README](docs/Gradle_README.md) for more info on
what Gradle is and how we're using it.

For the moment there are two things to try on the command line. Make sure you're
_in_ the directory containing your clone of the repo (i.e., you're in the
`intro-to-git` directory) and then run

```bash
./gradlew run
```

This will run our program, which should generate output that looks something like

```
> Task :run
Hello, folks!
KK says 'Hello!'
Nic says 'Howdy!'


BUILD SUCCESSFUL in 3s
2 actionable tasks: 2 executed
```

To run the tests try

```bash
./gradlew test
```

which should generate output something like

```
BUILD SUCCESSFUL in 827ms
3 actionable tasks: 3 up-to-date
```

If a test had failed, you would have gotten longer, more detailed information.
(Although you get better info from running the tests in VS Code – we'll see that
in a bit.)

### Opening our project in VS Code

Now we'll want to open VS Code and see how we can use it to edit and run our code.
Launch VS Code, and then choose `File -> Open Folder…`. Navigate to your clone 
of the repo and choose `Open`.

We've included a file in the project which specifies some VS Code extensions that
you should go ahead and install. VS Code will see that file automatically and give
a dialog on the bottom right that looks something like:

![Dialog suggesting installation of recommended extensions](https://user-images.githubusercontent.com/1300395/72710961-bf767500-3b2d-11ea-8ea4-fbbd39c78da5.png)

You can just click "Install All", but feel free to click "Show Recommendations" and
install them one at a time if you want to know more about what we're doing here.

Open up `src -> main/java -> Hellos.java` and you should see a small Java program.
Right above `public static void main` should be `Run | Debug` in light gray. These
aren't part of the code, but are action buttons being inserted by VS Code. Click
`Run` and it should run the program, opening up a terminal window in a pane along
the bottom to display the output. The output should look similar to what you got
with Gradle on the command line, but with some other info at the start before
the program's output is displayed.

Now open up `src -> test/java -> HellosTest.java` and you should see our JUnit
tests. Again, VS Code has inserted a few text `Run Test | Debug Test` "buttons"
in various places. Click `Run Test` just about `public class HellosTest` to
run _all_ the tests in the class.

Assuming the tests all passed (& they should), it won't really look like anything
actually happened. There will, however, be a checkmark to the right of
`Debug Test` that wasn't there before. That tells you the tests passed. If any of
the tests had failed, there'd be an `x` there, and VS Code would open up another
pane providing a list of all the tests and details on the failures to help you
debug the problem.

You can also run individual tests by clicking `Run Test` above the appropriate
test method.

### Create an info page for each pair

We'll come back to this Java code again in the second half of the lab, but
for now we're going to return to `git` by making and sharing changes.

This repository has a `user_info` directory, and in this part of the
lab we'll create a new file in that directory for each pair in the
class containing your real names and your GitHub user names. Sometimes
it's easy for us to figure out how those names relate, but if your
Gihub user name is `UnicornWizard375` it's not always obvious who in the
class that is, especially if you don't always wear your wizarding regalia to lab.

There will be several steps to this process, each of which is described in
more detail below:

- Create your contact info file/page
- `commit` that to your local copy of the repository
- `pull` down the changes other people may have made to the central repository on
  GitHub while you were working, `merging` them with your changes
- `push` your (merged) changes back up to GitHub so they're available to everyone

#### Creating a page

You'll start by creating your group's contact info page. Each contact
info page should:

- Be created in the `user_info` directory.
- Be named `<your_names>.md`, e.g., `Pat_and_Chris.md`
- Contain at least:
  - Each of your names as you preferred to be called
  - Your preferred pronouns
  - Your GitHub usernames (so we can figure out who `UnicornWizard375`
    is in real life)

Feel free to use the file `KK_and_Nic.md` as a model.

#### `commit` your changes (locally)

Before you can share your changes with the class via the GitHub repository,
you need to `add` and `commit` these changes to your local `git` repository.

On the command line type `git status`. That should tell you that something
like:

```
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)
  user_info/Pat_and_Chris.md

nothing added to commit but untracked files present (use "git add" to track)
```

This is telling you that while you've created your new file, you need to
use `git add` to _stage_ the file before you can _commit_ it.
You might think `git` should just commit any and all changes you've made
since the last commit. That's actually not a great default behavior, though,
because sometimes you've made changes to several files and you'd like to
commit them separately; with the right tools you can even commit different
changes to the same file in separate commits. This is useful because it makes
it easier to have a commit message that is specific to the particular changes
being committed (instead of a generic "changed a bunch of stuff" message that
you often get when there have been a lot of changes). This, and other nifty
things beyond the scope of this lab, is why `git` allows you to specify through
staging exactly what you wish to include in a commit.

**Stage the new file** so `git` knows you want to commit it through
`git add <file>` on the command line. (Note that the output of `git status`
told you that `git add <file>` was likely a useful thing to do at that point.)

**Check your status** again with `git status`. Now the output should be
something like:

```
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
  new file:   user_info/Pat_and_Chris.md
```

This tells you that you've successfully staged `user_info/Pat_and_Chris.md`.
It also tells you how you can _unstage_ a file that you might have staged by
accident.

**Commit the change** _to your local copy of the repository_ with `git commit`
on the command line.

- This will bring up a (command line) editor for you to enter
  your commit message. By default this is `vi/vim` for most people;
  ask for help if you find yourself [trapped in `vim`](https://qz.com/990214/a-million-people-have-visited-this-web-page-explaining-how-to-close-vim-a-notoriously-difficult-text-editing-program/) and [can't seem
  to escape](https://stackoverflow.blog/2017/05/23/stack-overflow-helping-one-million-developers-exit-vim/).
- You can also use `git commit -m "Your cool commit message"` to
  avoid being sent to an editor. We _strongly_ discourage this,
  however, as people rarely enter useful one-line commit messages.
- If `vi/vim` bugs you, you should probably set your default
  `git` editor to something you like. [This GitHub help page](https://help.github.com/articles/associating-text-editors-with-git/)
  shows you how to set various GUI editors like `atom`, but you
  could also use something like `git config --global core.editor nano`
  to set it to a command line editor like `nano`.

After entering a commit message that is [properly formatted](https://chris.beams.io/posts/git-commit/), [organized](https://dev.to/jacobherrington/how-to-write-useful-commit-messages-my-commit-message-template-20n9), [meaningful](https://www.freecodecamp.org/news/writing-good-commit-messages-a-practical-guide/) and [helpful](https://github.com/erlang/otp/wiki/writing-good-commit-messages)
you can exit the editor. That should finalize the commit, and you should get
output that looks something like:

```
[master 47d9c89] Adding the info for Pat and Chris.
 1 file changed, 11 insertions(+)
 create mode 100644 user_info/Pat_and_Chris.md
```

If you then run `git status` you should see that your file is no longer staged,
because it's been successfully committed!

#### `push`ing your work to GitHub

At this point you have your changes committed to your local copy of the
repository, and want to _push_ those changes up to the GitHub copy of the
repository. This is the potentially tricky part, but in this case things
should be well behaved. :smile:

The major issue is that other people may have made and `push`ed changes up
to GitHub that could potentially conflict with the changes you've made.
So your first step is to `pull` down any recent changes from GitHub:

```bash
git pull
```

Pay attention to whatever message you get; it's possible that there could
be problems (the word "conflict" would be a Bad Sign) so don't just ignore what
`git` tells you. Definitely ask questions if you get some verbiage from `git`
that you don't understand.

If no one else is working on these files in this repository (which is
likely in this case since you created a group-specific file for your
information) then this should go smoothly. As we'll see below, though,
if there have been changes in the same parts of the same files, a `pull`
can lead to conflicts and confusion.

Assuming that your `pull` works, then it's time to _push_ your
work up to the GitHub repository:

```bash
git push
```

Again, look for errors in the output of `git push`. If someone else managed
to do a `git push` between when you did `git pull` and tried `git push`, `git`
will complain and force you to do `git pull` again. Essentially you can never
`git push` unless `git` knows that you've got the latest copy of the world in
your repository.

When it succeeds, this will push all your commits up to GitHub; if you refresh
your view of the GitHub repository you should see your new file along with
your contact info, probably along with a lot of other files.

You're now done with the first major part of the lab!

## The second half: Collectively editing a program

:bangbang: Don't move on to this next part until _everyone_ is done with
the previous part.

:bangbang: You should definitely change _driver_ and _navigator_ roles now.

In this second part each group will make a small change to a simple Java
program, `Hellos.java` in the `program` directory. Each group will make a
small extension to that program in a way that virtually guarantees some sort
of merge conflict, so everyone will have the experience of dealing with
conflicts.

### Open GitKraken

Where we used command line commands to do all the `git` work in the previous
half, in this half we'll use `GitKraken`, which provides a nice GUI and
visualization of things like our commit history and branching.

Open up GitKraken. If this is your first time starting GitKraken it will ask you
to sign in, providing several options. You want to sign in with your GitHub account
as this will do two important things:

- It will allow GitKraken to push/pull/etc. with GitHub on your behalf.
- [**Assuming you've set up your GitHub Student Pack**](https://education.github.com/pack),
  this will automagically give you a Pro account on GitKraken, which includes
  some nice features that you'll want to have, like an interactive tool
  for resolving merge conflicts. :bangbang: _If you haven't set up your
  GitHub Student Pack, you should do so before setting up GitKraken._

After you've authenticated with GitHub, GitKraken will ask to setup
your `git` info ([like you did at the start for the command line](#configuring-your-git-e-mail));
you should enter your name and whatever email you've used for GitHub.

Once all the setup is finished, select `File -> Open` and navigate to the directory
containing your local clone, and open that up. There's a lot of information
here, but you can ignore most of it for now. One thing you should stand out
is the commit history graph. You should see all the commits you and all the
other groups made today.

Before we move on, it would be a good idea to do a pull just to make sure
we have the latest version of the code. In GitKraken you can just click the
`Pull` button in the toolbar at the top of the window. If there were recent
changes that you didn't have (which is unlikely), the history would update
to show the new commits you just pulled down to your local repository.

### Creating a branch

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
tests to your feature branch, then it will have no impact on people
working in other branches or on the build system, so everything will be
nice.

Every new `git` repository has one default branch called `master`; this is
usually where the current "deployed" or "released" version of the project
lives, while active development, bug fixes, and the like happen in other
development branches that are merged into `master` when that work is deemed
"done done" (passes the tests, has been through a code review, etc.).

To illustrate the use of branches, we'll have each group create a new branch
for their modification of the shared program. Assuming, for example, that
we still have Pat and Chris, they would create a new branch called something like `pat-and-chris-greetings`.

In GitKraken we can do this by clicking the `Branch` button in the toolbar. It
won't immediately look like anything actually happened, but there will be a
text box to the left of the history diagram where the _HEAD_ (top) of `master` is.
Enter your branch name (e.g., `pat-and-chris-greetings`) there and hit return. It
should now show (part of) `pat-and-chris-greetings` and a `+1` which indicates
that there's another branch (`master`) whose HEAD is at the same place. You should
also have `pat-and-chris-greetings` listed as a new branch under `LOCAL` in the
explorer on the left, and it should be highlighted to indicate that it is the
currently _checked out_ branch. That means that any new commits you make will
be _in that branch_ instead of in `master` as they were in the first half.

In the command line you could create and move to a new branch with something like

```bash
git checkout -b <new_branch_name>
```

This creates the new branch and perform a `checkout` on that branch.
The `checkout` part of the process tells `git` to "switch over" to that new
branch, so subsequent commits will happen on that branch. You use
`git checkout` without the `-b` to just switch between existing branches;
the `-b` tells `git` that this is a new branch that needs to be created.

### Edit the program

Now that you've created and switched to your new branch, it's time to edit
the program. Before we change anything, though, we should re-run our tests in
VS Code just to make sure everything's still good. While you're there notice
that VS Code automagically noticed that we'd switched to a new branch; down
in the left hand corner of the bottom status bar it should now have the name
of your branch where it used to say `master`.

Open up `Hellos.java` and add more lines in the `generateOutput()`
method of the form

```java
builder.append(patSaysHello());
```

where you replace `pat_says_hello` with method names that
reflects the names in your group. You should create one new method for
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
So let's fix that, by adding a new methods somewhere down amongst the example
methods; they should look something like:

```java
    private static String chrisSaysHello() {
        return "Chris says 'Hello!'\n";
    }
```

Make sure you include the `\n` (newline) in the string so we don't end up
with one really super long line. In fact our tests require that every greeting
have the form

```
   <name> says <greeting>!
```

so make sure you use the word "says" and end the greeting with an exclaimation
mark.

You can put your methods wherever you want in the `Hellos` class, but probably
makes sense to have them in the same order as the calls. Our tests don't check
that , though.

Once everything looks good, compile and run your program (by clicking `Run`
in `Hellos.java`) to make sure that everything is good. If you want to run
the program from the command line `./gradlew run` should do the trick.

You should also re-run the JUnit tests that will confirm that all the lines
in the output have the right form and are in alphabetical order.
In general you should always run the tests before you
commit as another way of making sure that your work is "done done".

:bangbang: If you have any problems here, definitely ask questions and get things
working before you proceed; you don't want to merge broken code and mess
things up for everyone else.

If you get stuck there definitely ask questions!

### Commit and Push your branch to GitHub

Now, assuming that your code is all working and happy, let's use GitKraken to
commit and push your work.

#### Commit with GitKraken

To commit in GitKraken click the top line in the history graph; its circle
should be an empty with a dotted line, and it should have `// WIP` where the
commit summary is. On the right you should then have panels labelled
"Unstaged Files", "Staged Files", and "Commit Message". Where you use
`git add` to stage files on the command line, in GitKraken you can select a file
in the "Unstaged Files" area and click the "Stage" button that appears next to
the file name. You can also see the changes you've made in that file, which can
be a huge help in forming useful, coherent commit messages.

So stage `Hellos.java`.

Now enter a commit message below that. GitKraken "enforces" that best practice
that your message should have a summary with no more than 72 characters, followed
by a more detailed description of the commit. Once you've staged one or more files
and entered a commit message, then you can click the "Commit changes" button on
the bottom right.

That should introduce a new commit to the history graph branching up from the
HEAD of `master`, with your summary message. Now we'll push!

#### Push with GitKraken

You could do a `pull` before the `push` like we did before, but
(a) you aren't expecting any changes on _your_ branch by another group (so
the `pull` shouldn't bring in any changes) and (b) `push` actually checks
for unpulled changes and forces you to deal with those if they exist (so it's
safe to just `push` and see what happens).

So hit `Push` in the GitKraken toolbar. It won't look like anything happened,
but there will be a question where the toolbar used to be. That should be something
like:

```
What remote/branch should "pat-and-chris-greetings" push to and pull from?
```

The issue here is we created a new _local_ branch, and GitKraken wants to know
what _remote_ repository to connect that two, and with what name. It will default
to `origin` (which is in this case another name for the GitHub repository we
cloned from) and our branch name (e.g., `pat-and-chris-greetings`). Those are
what we want, so hit `Submit`. After a second you should get a bubble in the
bottom left corner thays that the `push` was successful.

Assuming the `commit` and `push` worked, if you go to the project web page
on GitHub (and refresh if necessary),
your branch should be in the list of branches, and if you switch to your branch
and go look at `Hellos.java` you should see your changes. Depending on how
many other groups have gotten to this point before you, you may see a _lot_
of new branches; these will start to clutter things up, but we can delete
unused branches later.

If you go to the GitHub repo in the web, you should see your branch in the
branch dropdown. If you select it you should see your last commit just below
that. Next to the "Latest commit" label should either be a yellow dot, a
green checkmark, or a red x. These show you the build status of that commit.
Every time you (or anyone else) pushes to GitHub, we have GitHub Actions
set up so they run the JUnit tests against that version of the code. The
yellow dot means that it's still building and running the code. A green
checkmark means it's done and everything was great (the code compiled and
the tests passed). A red x means that something bad happened. If you click
on the symbol, you can get more information, including links to pages with
details on, e.g., failed tests.

### Merging your branch into `master`

It's cool that your changes are visible in your branch on GitHub, but if
you switch back to `master` on GitHub and look at `Hellos.java`, your code
won't be there. The problem with the current situation is that your nifty
new greetings are "trapped" in the branch you created.
This is sad, because your code is _spectacular_ and really
should be part of the "production" version of the project on the `master`
branch. Right? **Right?**

So you need to merge your branch into `master`.

If no one else was working on this repository it would be easy, and all
you'd need to do is _merge_ into `master` and then _push_ your work up
to the GitHub repository. But there are other people working on the
repository, and you have to make sure you play nice with them.

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

- `pull` changes into your development branch(es) early and often. The
  more consistent your branch is with `master` (or whatever branch you're going to
  merge into), the less likely conflicts will be, and they'll tend to be smaller
  when they do happen. The history/branch visualization in GitKraken can
  give you a sense of how far your branch is from what's on `master`.
- Break your work into small, manageable stories/tasks/chunks. Small,
  well-defined bits of work tend to touch less code and be completed more
  quickly, both of which reduce the likelihood of a nasty conflict surprise
  when you come to merge.
- Give yourself plenty of time to merge into `master`. You don't want to decide
  you're going to merge into `master` at 2am or 15 minutes before Food Service
  closes for dinner; if there's an unexpected conflict you don't have the
  time and energy to deal with it properly and your chances are much higher that
  you'll do something you'll regret.
- Don't do (big) merges alone (or at least make sure other folks are around).
  This relates to the previous one. If you're caught off guard by a conflict,
  and you're in a hurry, and there's no one around to help you understand how
  your changes relate to and will affect changes other people have made,
  Badness is very likely to ensue.

The basic process you'll typically want to follow is:

- Make sure all your changes on your feature branch are committed locally.
  - In GitKraken if there's no `WIP` entry then you know all your changes are
    committed. If there is an `WIP` entry, you can click on it to see what's
    not yet committed. (There can be times where you have changes you don't
    yet want to commit.)
  - Or use `git status` on the command line to confirm that everything you
    mean to have committed is in fact committed.
- Checkout the `master` branch
  - Double click on `master` in the branch listing on the lefthand side
    of GitKraken.
  - Or `git checkout master` on the command line

At this point you should be on the `master` branch, and all your work
on your new contact info page should "disappear" in VS Code. Don't worry, it's still
there in your feature branch, but it's not part of `master` so it's not
visible when we have `master` checked out.

The trick is that this is _your_ copy of the `master` branch, which is
probably out of date with `master` on GitHub (`origin/master`) since
other people have been committing and pushing changes. So you should
first make sure to `pull` any changes other people have made into your
copy:

- The `Pull` button in GitKraken
- `git pull` on the command line

Assuming you've _only_ made changes to your group's special development
branch, this `pull` should succeed with no difficulties, and `git` will
merge in whatever changes other people have `push`ed up to `master` on
GitHub into your copy of `master`. You might want to re-run the tests in
VS Code, though, just to make sure someone hasn't broken things.

Now we have the moment of truth, where you merge your changes from your
development branch (`pat_and_chris_greeting` in our example) into your
newly updated copy of `master`.

- In GitKraken, drag the label with the branch name that you want to merge
  (e.g., `pat-and-chris-greetings`) onto the branch you want to merge into
  (in this case `master`). That will bring up a dialog with several options.
  Go with the first one (probably "Fast-forward", but possible "Merge").
- On the command line `git merge <branch_name>` will merge the changes in
  the specified branch onto whatever branch is currently checked out (`master`)
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

- The attempt to `merge` will lead to a conflict; you'll have a message like
  "A file conflict was found when attempting to merge" up at the top of the
  commit history graph.
- All the files with merge conflicts will be listed in the "Conflicted Files"
  panel on the right hand side.
- Select a file with a conflict. That should bring up a GUI for resolving
  merge conflicts with one version (`master` in this case) on the top left,
  the version were trying to merge in (e.g., `pat-and-chris-greetings`) on
  the top right, and the `Output` (the result of the merge) at the bottom.
- You can then choose sections (using the checkboxes) that you want to include
  in the finished result. You can even choose to include (or not include)
  individual lines if you wish.
- When you're done click `Save`.
- That will move that file to "Staged Files", and you can move on to a
  commit like normal.

When that's all done then the merge conflict will be _resolved_ in `git`
terminology and you'll be (nearly) read to `push` your changes.

Before you do that, however, you should carefully
proofread any code that's modified in resolving a merge conflict, though,
as it's easy to introduce mistakes in that process.
You'll want to make sure you re-run the test suite, for example, to make
sure that resolving the merge conflict didn't inadvertently break something.

Once that's all happy, though, you should `push` your copy of `master`
up to GitHub.

Normally this should just work because you did a pull on `master` just
a few minutes ago. Occasionally, however, someone will manage to sneak
in a pushed change between your `pull` and `push`, and that's actually
pretty likely today with so many people working in parallel on the same
file. If that happens you'll get some sort of error saying that
your attempt to push `master` was rejected, and suggesting that you pull
or merge remote changes before you push.

So `pull` again, resolve any conflicts (including running the tests, etc.),
and try to `push` again. Because so many groups are modifying the same
file at the same time, it's entirely possible that this could take several
rounds before you get your changes pushed, but it will eventually happen.

When your `push` eventually works, and you should be able to look at the
repository on GitHub and see the changes you made to `Hellos.java` on the
`master` branch of the repository, presumably along with numerous changes
made by other groups. Check that the build is still successful (green checkmark)
and raise an alarm if it's not. (:bangbang: It's **never** a good thing
if your build on `master` is breaking, and everyone should stop what they're
doing to try to fix it when it does break.)

## Huzzah! We're done! :-)

Once everyone has added their changes to `Hellos.java` then we're
done with the lab! Well done! :smile:
