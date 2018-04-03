// Smart Strings
val multiLineString = """hello
                         @from
                         @another
                         @world""".stripMargin('@')
// default strip is "|" (pipe)
println(multiLineString)



val msg = "We are meeting on June 13th of this year, and having launch at 12:30PM"
val regex = """(\s|[0-9])?[0-9]:[0-5][0-9]\s*(AM|PM)""".r
// in smart strings we do not need to use escape sequences, eg: // for / !

println(regex.findAllIn(msg).toList)




// Format
val str1 = String.format("This is a %s", "Test")

val str2 = "This is a %s".format("Test")

println("Because you're %3$s, %2$s, %1$s times a lady".format("Three", "Twice", "Once"))


import java.time._
println("We will be eating lunch on %1$tB the %1$te in the year %1$tY.".format(LocalDate.now))
printf("We will be eating lunch on %1$tB the %1$te in the year %1$tY.", LocalDate.now)

// .format works also with smart strings...




// String Interpolation (s"...") or (f"...")
val a = 99
println(s"$a wohoooo")
println(s"${a+10} wohoooo")

val ticketCost = 50.2526
val bandName = "some band"
println(f"The $bandName%s tickets are probably $$$ticketCost%1.2f")
println(f"""The $bandName%s tickets are
        |probably $$$ticketCost%1.2f""".stripMargin)