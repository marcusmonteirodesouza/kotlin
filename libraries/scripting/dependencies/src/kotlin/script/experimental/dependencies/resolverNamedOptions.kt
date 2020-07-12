/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.script.experimental.dependencies

fun ExternalDependenciesResolver.Options.value(name: DependenciesResolverOptionsName) =
    value(name.key)

fun ExternalDependenciesResolver.Options.flag(name: DependenciesResolverOptionsName) =
    flag(name.key)

operator fun MutableMap<String, String>.set(key: DependenciesResolverOptionsName, value: String) {
    put(key.key, value)
}


enum class DependenciesResolverOptionsName {
    TRANSITIVE,
    DEPENDENCY_SCOPES;

    val key
        get() = this.name.toLowerCase()
}

val ExternalDependenciesResolver.Options.transitive
    get() = flag(DependenciesResolverOptionsName.TRANSITIVE)

val ExternalDependenciesResolver.Options.dependencyScopes
    get() = value(DependenciesResolverOptionsName.DEPENDENCY_SCOPES)?.split(",")
