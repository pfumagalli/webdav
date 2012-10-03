# A Simple Approach To WebDAV #

> ### Release 0.4 ###

> The 0.4 release of the WebDav servlet is available for [download as a
> JAR](https://github.com/downloads/pfumagalli/webdav/webdav-0.4.jar)
> (Sources via [GitHub](https://github.com/pfumagalli/webdav/tags)).
> 
> This release is the first one to feature our new package naming `it.could`
> and provides an experimental way to manage replicated repositories.
> 
> Replicated repositories work with a master repository where all your users
> write to. Every modification made onto this one gets _replicated_ onto a
> number of different slave repositories (so, add one file, it gets copied
> on as many servers as you want), and is particularly useful when dealing
> with a pool of load-balanced servers whose resources must be kept in sync
> at alltimes.
> 
> The documentation is provided as together with the
> [JavaDoc](http://pfumagalli.github.com/webdav/), and there is an overall
> page describing the [installation process](http://pfumagalli.github.com/webdav/it/could/webdav/package-summary.html).

In some cases it's really essential to have a small and quick way to access
files in a web application through the
[WebDAV](http://www.rfc-editor.org/rfc/rfc2518.txt) protocol.

Currently, though, there are only two alternatives in the Java world to
achieve this: either one relies on the WebDAV capabilities built in [Apache
Tomcat](http://jakarta.apache.org/tomcat/) or relies on [Apache
Slide](http://jakarta.apache.org/slide/).

I tend to use [Jetty](http://jetty.mortbay.org/) on production (given that
I find it more reliable and performant than
[Tomcat](http://jakarta.apache.org/tomcat/)), and for what I need,
[Slide](http://jakarta.apache.org/slide/) is _way too big_, so, a couple of
months ago, out of desperation, I decided to write my own tiny WebDAV
servlet.

My implementation does not in any way try to replace or extend
[Slide](http://jakarta.apache.org/slide/), it only tries to provide a very
light and extremely minimal alternative to it, useable in those scenarios
where space is a constraint (the .jar file is less than 100 kylobites), and
advanced features are not required.

Originally, I would have liked to have this servlet hosted alongside
[Slide](http://jakarta.apache.org/slide/), but after talking about it on
the [mailing
list](http://marc.theaimsgroup.com/?t=110892078700004&r=1&w=2), filed an
[improvement
request](http://issues.apache.org/bugzilla/show_bug.cgi?id=33705) and
waiting for more than a month, I had no reply. I know now that the main
reason of this silence was because
[Slide](http://jakarta.apache.org/slide/) has a different aim in life (big
and feature compliant, rather than minimal and barely covering essentials),
so, here we are, back "at home"...

## Limitations ##

The most visible limitations of this approach is that this implementation
does not offer any support for the `LOCK` method (it is therefore not DAV
Level 2 compliant), and that there limited support for properties:

* The `PROPFIND` method will only return the read-only getcontenttype,
getlastmodified, getcontentlength, getetag and resourcetype properties. *
The `PROPPATCH` method will always fail with a _403 Forbidden_ error.

Another important limitation is that this implementation will only and
exclusively provide access to a `File` based backend. If you want to deploy
your repository on another kind of backend (such as SQL databases) please
look at the [WebDAV](http://www.rfc-editor.org/rfc/rfc2518.txt)
implementation provided by [Apache Slide](http://jakarta.apache.org/slide/).
