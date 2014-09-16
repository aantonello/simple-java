simple-java
===========

Simple Framework for Java development.

This is a set of classes and helper files that I used for many, many years
since I started developing applications for J2ME platforms. At that time this
was a single JAR file imported in all my applications. Time passed and Android
came up. Now we cannot have all files in a single JAR because some files has
the same names but different implementations. So we need to split it up in
several JAR files that can be imported separated and used together.

This is a working in progress library. It is not finished and, I think, it
will never be. Be prepared to some unsolved bugs and lack of some features
since I spend some time on it only in my spare hours.

If you find some bug, please, let me know. My e-mail is:
antonello dot ale at gmail dot com.

simple.vip
----------

The ``simple.vip`` is my project structure. I edit the source code using
[Vim/GVim](http://www.vim.org) editor, that I love. Together with [Project
plugin](https://github.com/aantonello/project_vim) based on
(http://www.vim.org/scripts/script.php?script_id=69) is my perfect combination
of using Vim as an IDE like environment.

Makefiles
---------

Usually I write makefiles by hand. I don't like Eclipse nor Ant. A ``build.xml``
file is nothing more than a makefile in XML format (too much verbose for
my taste). I would change to CMake but I haven't had the time to get the grips
of it yet. So, I stick with hand made makefiles that works well.

The file ``make.inc`` has the list of files to compile and some variables
defining paths. The ``Makefile`` script, that includes ``make.inc`` should
work without changes when the ``make.inc`` is well set up. I use the same
script in Windows and Mac OS X.

Documentation
-------------

I used JavaDoc once. But compared with Doxygen it is light years behind so,
despite it is not *Java standard* I will use it for documentation.

Final Explanations
------------------

I don't know Java much. I started using it when building applications for J2ME
supporting cellphones. Now I use it with Android. So this is not a too generic
framework. It is more like a helper in the mess that Android SDK is. Also
makes me comfortable with the oddities of the Java language. My background is
C/C++ so, that is the case of all this.

