package com.solo4.kinoapp.common

import com.solo4.kinoapp.common.utils.MOVIES_LIST_PAGE_SIZE
import org.junit.Test

class ConstantsTest {
    @Test
    fun `movies list page size must be greater then 0 test`() {
        assert(MOVIES_LIST_PAGE_SIZE > 0)
    }
}
