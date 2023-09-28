package com.solo4.kinoapp.common

import com.solo4.kinoapp.common.utils.LambdaWithParameter
import org.junit.Test

class AppTypealiasTest {

    @Test
    fun `lambda with parameter test`() {
        val lambda = { str: String -> /* some action */}
        assert(lambda is LambdaWithParameter<String>)
    }
}
