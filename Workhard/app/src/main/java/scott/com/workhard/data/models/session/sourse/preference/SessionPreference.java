package scott.com.workhard.data.models.session.sourse.preference;

import scott.com.workhard.utils.preferences.PreferenceUtils;

/**
 * @author pedroscott. scott7462@gmail.com
 * @version 10/10/16.
 *          <p>
 *          Copyright (C) 2015 The Android Open Source Project
 *          <p/>
 *          Licensed under the Apache License, Version 2.0 (the "License");
 *          you may not use this file except in compliance with the License.
 *          You may obtain a copy of the License at
 *          <p/>
 * @see <a href = "http://www.aprenderaprogramar.com" /> http://www.apache.org/licenses/LICENSE-2.0 </a>
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


public class SessionPreference extends PreferenceUtils {

    public static final String PREFERENCE_TOKEN = "preference_token";

    public static void setPreferenceToken(String enabled) {
        getEditor().putString(PREFERENCE_TOKEN, enabled).apply();
    }

    public static String getPreferenceToken() {
        return getPreferences().getString(PREFERENCE_TOKEN, null);
    }



}