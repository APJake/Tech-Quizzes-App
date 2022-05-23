package com.apjake.techquizzes.common.base

interface UniMapper<A,B> {
    fun map(data: A): B
}