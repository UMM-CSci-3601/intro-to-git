# Faculty instructions for setting up the repository <!-- omit in toc -->

- [Overall instructions](#overall-instructions)
- [Set up various apps](#set-up-various-apps)
  - [GitKraken](#gitkraken)

Each semester we need to do a certain amount of setup for that
semester's copy of this repository. Below are the instructions
for setting that up.

## Overall instructions

Before you can really do anything you'll need to

- [ ] Create a GitHub organization for this semester, e.g., [UMM-CSci-3601-S22](https://github.com/UMM-CSci-3601-S22)
  - [ ] You probably want to add your TAs as owners on that org.
  - [ ] It's often helpful to create a semester specific logo
        for the organization, especially if you're part of
        numerous organizations. It's probably also a good example
        to set for the students.
  - [ ] Make sure we've added every student in the current semester
        to that semester's organization so they'll have
        permission to push to this repo.
- [ ] Create a GitHub Classroom for this semester
- [ ] Create a new assignment using this repo as the template
  - [ ] We usually make students admins on their repos.
  - [ ] It's probably useful to include the Feedback branch
  - [ ] You probably want to limit the assignment to a single team.
  - [ ] We usually use "Everyone" as the name for the set of
        teams; GitHub Classroom will then call the shared
        repository `intro-to-git-everyone`, which is nice.
  - [ ] Post the invite link to the GitHub Classroom assignment on the LMS (e.g., Canvas)

Now it's useful to "force" the creation of the repository in
this semester's organization/classroom. You can just follow
the "student" invite link, and that will create that semester's
copy of the repository.

Now make a few changes to the _classroom copy_ of the repository:

- [ ] Fix the URLs in the badges below so they point to that semester's
    repository instead of the "starter" repo.
- [ ] [Turn off branch protection](FACULTY_BRANCH_PROTECTION_SETTINGS.md)
    so that students can `push`.
- [ ] Remove the note and the broken badge at the top of the
      README _in the classroom copy_.
  - We don't want to remove those from the starter copy since we
    need to be reminded of these rules each semester.

## Set up various apps

As well as setting up the classroom and the initial repository,
we need to set up various apps that will need access to this
organization.

### GitKraken

We need to enable GitKraken on the new, semester specific organization.
To do this you _have_ to be an admin on the
organization for this semester; that will be true "for free"
if you're the person that created the organization above.

- [ ] Go to <https://github.com/settings/connections/applications/>
- [ ] Click on "GitKraken"
- [ ] Grant access to the new semester's organization in the list of
      organizations on that page
