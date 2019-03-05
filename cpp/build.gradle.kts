plugins {
    `cpp-library`
    `cpp-unit-test`
}


library {
    baseName.set("jonnyzzzcpp")
}


afterEvaluate {
    for (c in configurations) {
        println(c)
    }
}
