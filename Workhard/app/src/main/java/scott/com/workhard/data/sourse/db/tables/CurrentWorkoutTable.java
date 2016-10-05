package scott.com.workhard.data.sourse.db.tables;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import rx.Observable;
import scott.com.workhard.entities.Exercise;
import scott.com.workhard.entities.Workout;

/**
 * Created by androiddev3 on 10/5/16.
 */

public class CurrentWorkoutTable extends RealmObject {
    private String id;
    private int restBetweenExercise;
    private int restRoundsExercise;
    private int rounds;
    private String currentExercise;
    private String name;
    public RealmList<ExerciseTable> exercises;

    public CurrentWorkoutTable(Workout workout) {
        setId(workout.getId());
        setName(workout.getName());
        setRestBetweenExercise(workout.getRestBetweenExercise());
        setRestRoundsExercise(workout.getRestRoundsExercise());
        setRounds(workout.getRounds());
        setCurrentExercise(workout.getCurrentExercise());
        RealmList<ExerciseTable> exerciseTables = new RealmList<>();
        for (Exercise exercise : workout.getExerciseList()) {
            exerciseTables.add(new ExerciseTable(exercise));
        }
        setExercises(exerciseTables);
    }

    public CurrentWorkoutTable() {
    }

    public String getCurrentExercise() {
        return currentExercise;
    }

    public void setCurrentExercise(String currentExercise) {
        this.currentExercise = currentExercise;
    }

    public RealmList<ExerciseTable> getExercises() {
        return exercises;
    }

    public void setExercises(RealmList<ExerciseTable> exercises) {
        this.exercises = exercises;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestBetweenExercise() {
        return restBetweenExercise;
    }

    public void setRestBetweenExercise(int restBetweenExercise) {
        this.restBetweenExercise = restBetweenExercise;
    }

    public int getRestRoundsExercise() {
        return restRoundsExercise;
    }

    public void setRestRoundsExercise(int restRoundsExercise) {
        this.restRoundsExercise = restRoundsExercise;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public Observable<Workout> transformToWorkout() {
        return Observable.just(new Workout().withId(getId())
                .withName(getName())
                .withRestBetweenExercise(getRestBetweenExercise())
                .withRestRoundsExercise(getRestRoundsExercise())
                .withRounds(getRounds())
                .withExercises(getExercisesList()));
    }

    public List<Exercise> getExercisesList() {
        List<Exercise> exercisesList = new ArrayList<>();
        for (ExerciseTable exerciseTable : getExercises()) {
            exercisesList.add(exerciseTable.transformToExercise());
        }
        return exercisesList;
    }
}
