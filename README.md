**Note: Since converting packs isn't possible with the program on it's own, please use Mojang's [TextureEnder](https://github.com/Mojang/TextureEnder) to convert texture packs to resource packs, and either Hypixel's [Resource Pack Converter](https://github.com/HypixelDev/ResourcePackConverter) or Mojang's [slicer](https://github.com/Mojang/slicer) to convert old resource packs to the 1.13/1.14 format.**

# Minecraft Pack Workbench

MCPW is a tool for editing Minecraft resource/texture packs.
Originally forked from [**Resource Pack Workbench**](https://github.com/mcRPW/rpw).

**Pull Requests are welcome!**

Please read the built-in help before asking questions, and go through the MCPW menus.
Many options are in the context menu when clicking assets!

## Links
- [**Official MCPW website**](https://thealiendrew.github.io/mc-pack-workbench)
- [MCPW on Twitter (announcements)](https://twitter.com/Alien_Drew)
- [**Official RPW website**](https://mcrpw.github.io/) (Archived version in case the site goes down is [here](https://web.archive.org/web/20190522074541/https://mcrpw.github.io/) as it appeared on May 22, 2019)
- [RPW on Twitter (announcements)](https://twitter.com/RPWapp)

## FAQ

**Q: MCPW opens images in Paint instead of Gimp. How to fix?**

Please see issues [#53](https://github.com/mcRPW/rpw/issues/53) and [#58](https://github.com/mcRPW/rpw/issues/58).

**Q: How to import an existing pack?**

Either add it to library so you can remix it (library menu), or create a new project (project menu) and select "From existing pack".

## Support?

For help with using MCPW, please tweet me on Twitter:

[<img src="https://i.postimg.cc/rpk5KGJt/tweet-to-alien-drew.png" alt="Tweet @Alien_Drew" width="30%">](https://twitter.com/intent/tweet?screen_name=Alien_Drew&ref_src=twsrc%5Etfw)

## Setting up MCPW for development

*If you plan to work on MCPW's source code:*

Currently MCPW is set up as an IntelliJ IDEA project, but what IDE to use is up to you.

It's a Maven project, so all libraries should be downloaded by the IDE automatically.
