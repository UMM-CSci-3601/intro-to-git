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

* Be named `<your_name>.md`, e.g., `Nic_McPhee.md`
* Contain at least:
   * Your name as you preferred to be called
   * Your preferred pronouns
   * Your preferred way(s) for people to contact you, perhaps with some
   info on which one(s) people should use if they need to get in touch
   quickly
   * Any constraints on any of that info, e.g., "Don't call the
   apartment phone after 10pm or my roommate won't do dishes for a week."

Your preferred contact methods is arguably the tricky part of this.
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
    * `VCS -> Commit Changes…` in WebStorm. This gives you a nice
    dialogue where you can select which files you actually
    want to include in this commit. You can also use the `Diff` tool
    in that dialogue to remind yourself of what all you've changed,
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
This will push all commits on your current branch so a branch with the
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
to the Github repository.



* `git push` on the command line
* `VCS -> Git -> Push…` in WebStorm
This would push all commits on your current branch (remember that you're
working on a special branch you created for this contact info document!)
so a branch with the same name up on Github.

If no one else has pushed any changes since you last checked out or
pulled, then all you'll need to do is push. If, however, someone else
has pushed, attempted to push will fail with a message saying that you
need to pull first. With so many people editing the same repository at
the same time this will be the most common scenario, and you will need
to pull first:
* `git pull` on the command line
* `VCS -> Git -> Pull…` in WebStorm
If things go smoothly