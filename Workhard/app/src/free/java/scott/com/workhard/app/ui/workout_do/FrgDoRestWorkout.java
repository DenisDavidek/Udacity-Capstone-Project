package scott.com.workhard.app.ui.workout_do;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import scott.com.workhard.R;
import scott.com.workhard.entities.Workout;

/**
 * @author pedroscott. scott7462@gmail.com
 * @version 9/3/16.
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
public class FrgDoRestWorkout extends FrgBaseDoRestWorkout {

    @BindView(R.id.adVFrgDoWorkout)
    AdView adVFrgDoWorkout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static FrgDoRestWorkout newInstance(Workout workout, int timer) {
        Bundle args = new Bundle();
        args.putInt(TIMER, timer);
        args.putParcelable(Workout.WORKOUT_ARG, workout);
        FrgDoRestWorkout fragment = new FrgDoRestWorkout();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initViews() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adVFrgDoWorkout.loadAd(adRequest);
    }


}
