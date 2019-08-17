/*
 * *
 *  * Copyright (c) 2018-present, FormValidator Contributors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 *  * compliance with the License. You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software distributed under the License is
 *  * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 *  * the License for the specific language governing permissions and limitations under the License.
 *
 */

package main.java.com.simicaleksandar

import java.util.regex.Pattern

sealed class ValidationRule {

    data class Optional(val isRequiredToMeetOtherRulesIfNotEmpty: Boolean = true): ValidationRule()

    sealed class Text: ValidationRule() {

        sealed class Length: Text() {

            data class Min(val count: Int, val trimWhitespaces: Boolean = false): Length()
            data class Max(val count: Int, val trimWhiteSpaces: Boolean = false): Length()
        }

        object NotEmpty: Text()
        object NotBlank: Text()
        data class RegExp(val pattern: Pattern): Text()
    }
}

