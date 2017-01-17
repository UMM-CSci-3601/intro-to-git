# Introduction to `git`

This will be an in-lab exercise where we'll experience several of the
key features of the `git` version control system, and the Github
repository hosting service.

:bangbang: While in most labs it will be fine for groups to move ahead
at their own pace, in this lab we'd like people to keep together
because there are moments where we're expecting certain things to
happen (e.g., merge conflicts) and we want everyone to be in roughly
the same place when that happens.

This definitely will _not_ provide a comprehansive overview of the
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

The discussion below assumes that people are paired up in the lab, and
there will be times where one person will need to log out and let their
partner login so that everyone has a chance to go through all the
activities.

:bangbang: This repository will be private so only people in the class
(and the faculty and TAs) will have access to this contact info.
Everyone in the class will have access to it, though, so you should
put some thought in what you want to share.

# Create a contact info page for (each of) you

This repository has a `contact_info` directory, and in this part of the
lab we'll create a new file in that directory for every person in the
class, containing their personal contact info.

:question: KK – do we want to have person X type up person Y's info
and vice versa so everyone is in some way involved all through the
process? I'm going to write it up that way below, but we can definitely
change that if you think that's a bad idea.

In order to keep everyone engaged throughout, we'll model the ideas of
a _driver_ and _navigator_ in [pair programming](https://en.wikipedia.org/wiki/Pair_programming).
Imagine, for example, a group of two working together, Pat and Chris,
and Pat is currently logged in. Then Pat would create the contact info
document for _Chris_, asking Chris for the relevant information and
entering it. When that's done, Pat will commit that work, and then log
out, allowing Chris to log in and repeat the process creating _Pat's_
contact info page.

## Creating a branch

`git` branches are frequently used as ways to isolate work (in progress)
on a particular feature from other on-going work on the project.
Creating and working in your own feature branch allows you to commit
and share incomplete work without breaking the project for other people.

To illustrate the use of branches (which arguably aren't really needed
for this simple project), we'll create a new branch for the creation
of each contact info page. So in the example above, the first thing
that Pat would do would be to create a branch for the creation of
Chris's contact info page.

In the command line this would be accomplished with
```bash
git checkout -b <branch_name>
```
so Pat might use `git checkout -b chris_info` to create the branch for
setting up Chris's info.

In WebStorm, you can accomplish this through the
`VCS -> Git -> Branches…` dialogue, choosing the `New Branch` option.

## Creating a page

Once you've created the branch it's time to create your partner's
contact info page.

Each contact info page should:

* Be named `<their_name>.md`, e.g., `Nic_McPhee.md`
* Contain at least:
   * Their name as you preferred to be called
   * Their preferred pronouns
   * Their preferred way(s) for people to contact you, perhaps with some
   info on which one(s) people should use if they need to get in touch
   quickly
   * Any constraints on any of that info, e.g., "Don't call the
   apartment phone after 10pm or my roommate won't do dishes for a week."

The preferred contact methods is arguably the tricky part of this.
You should _not_ feel that you
need to share contact info you're not comfortable sharing. So if you
want to include a phone number, that's fine, but it's _equally_ fine if
you don't. Whatever you do share, though, it would be good if there is
some way that your team can contact you quickly if something blows up.

:bangbang: Remember to treat everyone's information with respect and use
it in reasonable ways. Everyone's trusting us both individually and as
a community to not do dumb or inappropriate things with this information,
so let's be careful to not abuse that trust.

Feel free to be creative about this. Do you obsessively follow your
Twitter account, thereby making a Twitter direct message a pretty
reasonable approach? Also feel free to come back and update this info
as the semester progresses. People are probably most likely to look
things up here in the second half of the semester when the groups are
bigger and the team coordination gets more complex, so changes you
make are likely to still be useful even if they're several weeks after
we "complete" this lab.

:bangbang: If you create the new file with WebStorm it's likely to
ask you if you want to add it to the set of files that were being
tracked by `git`. If that happens, say "Yes" to simplify things later,
although it's not a big deal if you say "No".

## Sharing that new page

After a page is created, you need to share that with the class by
adding it to the repository on Github.

Because you've created your own branch to work in, the beginning of
this is easy:

* Stage the new file so `git` knows you want to commit it
   * `git add <filename>` on the command line
   * `VCS -> Git -> Add` in WebStorm (although if you used WebStorm to
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
      * So if `vi/vim` bugs you, you should probably set your default
      `git` editor to something you like. [This Github help page](https://help.github.com/articles/associating-text-editors-with-git/)
       shows you how to set various GUI editors like `atom`, but you
       could also use something like `git config --global core.editor nano`
       to set it to a command line editor like `nano`.
   * `VCS -> Commit Changes…` in WebStorm. This gives you a nice
    dialogue where you can select which files you actually
    want to include in this commit. This is useful because you may have
    made a few changes that are related to different issues – this dialogue
    makes it easier to comment separately on unrelated changes, increasing
    the value of your commits and commit messages. You can also use the
    `Diff` tool in that dialogue to remind yourself of what all you've changed,
    which makes it easier to write
    [informative, complete commit messages](http://chris.beams.io/posts/git-commit/).

## Pushing your branch to Github

At this point you have your changes committed to your local copy of the
repository, and want to _push_ that change up to the Github copy of the
repository. This is the potentially tricky part. :smile:

If no one else is working on this branch in this repository (which is
likely in this case since you're working on a special branch you created
for this contact info document) all you'll need to do is _push_ your
work up to the Github repository:
* `git push` on the command line
* `VCS -> Git -> Push…` in WebStorm
This will push all commits on your current branch to a branch with the
same name up on Github; if you refresh your view of the Github repository
you should see your branch listed, probably along with a lot of other
branches. (All these branches will start to clutter things up, and we'll
look later at cleaning house.)

## Merging your branch into `master`

The problem with the current situation is that your nifty new contact
info document is "trapped" in the branch you created. If you look at that
branch on Github, you'll see your new document, but if you're on any
other branch (such as `master`, which is the "default" branch people
see when they go to the project), your file won't be there.

So you need to _merge_ your work onto the `master` branch.

If no one else was working on this repository it would be easy, and all
you'd need to do is _merge_ into `master` and then _push_ your work up
to the Github repository. But there are other people working on the
repository, and you have to make sure you play nice with them.

The basic process you'll typically want to follow is:
* Make sure all your changes on your feature branch are committed locally.
   * `git status` on the command line
   * The "Local Changes" tab in the "Version Control" window in WebStorm
* Checkout the `master` branch
   * `git checkout master` on the command line
   * `VCS -> Git -> Branches…` in WebStorm, and then choose `master ->
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
* `VCS -> Git -> Pull…` in WebStorm
If you're lucky, any changes you've made won't interact badly (_conflict_)
with changes other people have made. That should be the case here because
so far everyone's working on completely different files and you haven't
made any changes to the `master` branch, so we'll ignore
merge conflicts for now and return to them in later in the lab.

You've now got the latest version of `master`, which may include various
changes other people have made. You need to _merge_ your changes from
your feature branch into the `master` branch.
* `git merge <feature branch>` on the command line
* `VCS -> Git -> Merge Changes…` brings up a dialogue where you can then
choose the branch(es) you want to merge into your currently checked out
branch (`master` in this case). Check the box by your feature branch and
hit `Merge` and you should get your changes merged in.

Now that your copy of `master` has your work on it, you want to push
that up to Github:
* `git push` on the command line
* `VCS -> Git -> Push…` in WebStorm

Normally this should just work because you did a pull on `master` just
a few minutes ago. Occassionally, however, someone will manage to sneak
in a pushed change between your `pull` and `push`, and that's actually
pretty likely today with so many people working in parallel on the same
repository. If that happens you'll get some sort of error saying that
your attempt to push `master` was rejected, and suggesting that you pull
or merge remote changes before you push. WebStorm lets you do this from
the error dialogue – if you click the `Merge` button WebStorm will pull
down the changes from Github and merge them into your `master`.

At that point you would try to `push` again, repeating the pull/merge
step yet again if someone has once again snuck in on you. Eventually,
though, your `push` should work, and you should be able to look at the
repository on Github and see your new contact info document.

At this point logout and trade with your partner(s) as appropriate until
everyone has gone through this part of the lab.

# Bringing it all together!

:bangbang: Don't move on to this next part until _everyone_ is done with
the previous part.

:bangbang: If we were doing more complicated changes we'd want these to
each be in separate branches, but in order to keep things a little
simpler, we'll do the rest of this directly on the `master` branch.
Make sure that `master` is the branch you're currently working on.

Once everyone is done with the previous part, we should have a bunch of
separate Markdown files in the `contact_info` directory, one for each
person in the class. Now we'll bring them together into a smaller set of
cummulative documents with the ultimate goal of creating a single long-ish
document with _everyone's_ contact info, organized in alphabetical order
by people's names.

This arguably isn't really necessary, but it will have the advantage of
creating some merge conflicts so people will have a chance to see what
that looks like and how to deal with it.

There is a `team_info` directory that has three mostly empty
Markdown files, `Team_A.md`, `Team_B.md`, and `Team_C.md`. At this point in
the lab we'll split you into three teams, either `A`, `B`, or `C`.

You should open the file associated with the team you were assigned to,
and then enter (copy and paste is fine) all the contact info your partner
in your group (i.e., Pat would enter Chris's info) :bangbang: in
alphabetical order by people's names.

Then commit (to `master`) that person's info and push those changes
to Github, switch places (log out and in, etc.) again, and repeat
until everyone in your group has added, committed, and pushed their
partner's contact info.

Unless you get really lucky, this will at a minimum require
some pulling and merging before you get your push to work. It's quite
likely (and nearly guaranteed when you do the second person in your group)
that you'll get some sort of merge conflict when you pull down other
people's changes.

This is because multiple people will have almost certainly changed the
same line of your team's file _in different ways_, and `git` doesn't
pretend to be able to figure out whose changes should "win". So it throws
up it's (figurative) hands and tosses the problem back in your lap.

:bangbang: _Any_ push can lead to merge
conflicts, and merge conflicts often take a little time to deal with
properly. Thus you should avoid trying to "do a quick push" right
before you need to leave for class, or when it's late and you're really
tired, or something similar. If a conflict results, people often end up
getting stressed, increasing the chances that they'll do something that
will tick off a teammate or
which they'll later regret for some other reason. So if you have an hour
to work on something, for example, you probably want to save 10-15
minutes of that for committing (so you have time to write good commit
messages), pushing, and otherwise cleaning up after yourself.

Dealing with these kinds of merge conflicts can be a frustrating
experience, but WebStorm has a nice GUI merge conflict tool that makes
it a little easier. The sequence of events (in WebStorm) is likely to
look something like:

* An attempt to `push` will be rejected.
* The dialogue that tells you this will include "Cancel", "Merge", and
"Rebase". For the moment, choose "Merge".
* That brings up a new dialogue listing each file that had a conflict.
There's likely just the one in this case, your team's file.
Select it and click "Merge".
* That brings up a dialogue with the original version of the document
in the middle pane, and your version and the version with the conflicting
changes in the left and right panes. You can use the `>>`/`<<` symbols
to copy changes from the left or right pane into the result, or click
the little magic wand (?) icon to let WebStorm take it's best guess at
the right merge. (If at any point you end up something icky, you can
click the "Abort" button and try again. You can also directly edit
the middle pane to tweak the results.)

When that's all done then the merge conflict will be _resolved_ in `git`
terminology, and you can try the `push` again. You should carefully
proofread any code that's modified in resolving a merge conflict before
`push`ing, though, as it's easy to introduce mistakes in that process.
Later, when we're working with code instead of just text, you'll want to
make sure you re-run the test suite to make sure that resolving the
merge conflict didn't inadvertently break something.

# Huzzah! We're done!

Once everyone has added their group's info to the team files then we're
done with the lab! If there's time, then we might merge the three
team files into a single big "master" file in class; otherwise we'll do
that after lab is done.

