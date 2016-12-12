package scott.com.workhard.data.sourse.rest;

import scott.com.workhard.R;
import scott.com.workhard.app.App;

/**
 * @author pedroscott. scott7462@gmail.com
 * @version 10/23/16.
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
public class ErrorFactory {

    public static final int GENERAL_DEFAULT_ERROR = -1;

    public static String getErrorMessage(int code) {
        try {
            int id = App.getGlobalContext().getResources().getIdentifier("error_code_" + code, "string",
                    App.getGlobalContext().getPackageName());
            return App.getGlobalContext().getString(id);
        } catch (Exception e) {
            return App.getGlobalContext().getString(R.string.network_error_code_general);
        }
    }


}
