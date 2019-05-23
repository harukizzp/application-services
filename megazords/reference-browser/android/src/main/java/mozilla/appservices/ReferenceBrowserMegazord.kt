/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mozilla.appservices

class ReferenceBrowserMegazord {
    companion object {
        @JvmStatic
        fun init() {
            System.setProperty("mozilla.appservices.fxaclient_ffi_lib_name", "reference_browser")
            System.setProperty("mozilla.appservices.logins_ffi_lib_name", "reference_browser")
            System.setProperty("mozilla.appservices.places_ffi_lib_name", "reference_browser")
            System.setProperty("mozilla.appservices.push_ffi_lib_name", "reference_browser")
            System.setProperty("mozilla.appservices.rc_log_ffi_lib_name", "reference_browser")
            System.setProperty("mozilla.appservices.viaduct_lib_name", "reference_browser")
        }
    }
}
