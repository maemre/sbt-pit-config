# sbt-pit-config
An example for using [pitest](https://pitest.org) with SBT and scripts to download &amp; setup the SBT plugins.

Run `./get-sbt-plugins.sh` to download and install the SBT plugins locally. See the `example/` folder for an example project. This configuration uses:

 + [sbt-pit](https://github.com/alexec/sbt-pit) to run pitest through SBT.
 + [pitest-scalatest-plugin](https://github.com/alexec/pitest-scalatest-plugin) to make pitest discover ScalaTest tests.

Check `CRAPL-LICENSE.txt` for license.
