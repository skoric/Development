
# Start of the day

At the beginning of the day, users can only enter their weight. If none entered, the one from the previous day will be used.
# End of the day questionnaire

Questions to ask user at the end of each day:
### Food Questions

"How much did you eat today compared to your usual needs?"

|Level|Answer (Short)|Description (Hint)|
|---|---|---|
|**0**|Barely ate anything|Almost no food — maybe skipped meals, just a snack or two.|
|**1**|Very little|Much less than usual — light snacking, no full meals.|
|**2**|Less than normal|Ate less than your needs — one small meal, maybe a light snack.|
|**3**|Slightly less|Ate a bit less than normal, might feel a little hungry.|
|**4**|Normal|Ate just about right — satisfied but not stuffed.|
|**5**|Slightly more|Ate a bit more than usual — maybe an extra snack or larger portions.|
|**6**|More than normal|Ate noticeably more than you needed, feeling full.|
|**7**|A lot more|Overate — heavy meals, multiple snacks, feeling stuffed.|
|**8**|Way too much|Significantly overate — uncomfortably full or bloated.|
### Food Tags

"What influenced your eating today?"

1. `Eating out` 🍽️
2. `Alcohol` 🍷
3. `Social` 🥳
4. `Stress` 😣
5. `Bored` 😐
6. `Tired` 😴
7. `Cravings` 🤤
8. `Dehydrated` 💧
9. `Planned meals` 📅 _(positive)_
10. `Portion control` ⚖️ _(positive)_
11. `Mindful eating` 🧘‍♂️ _(positive)_
12. `Healthy swaps` 🥗 _(positive)_

### Activity Questions

"How active were you today?"

| Level | Answer (Short) | Description (Hint)                                                 |
| ----- | -------------- | ------------------------------------------------------------------ |
| **0** | No activity    | Rest day — mostly sitting or lying down, minimal movement.         |
| **1** | Light          | Light movement — short walk, light chores, no real workout.        |
| **2** | Moderate       | Some sustained activity — brisk walking, cycling, active job.      |
| **3** | Active         | Exercise or physical work — gym session, sports, long hike.        |
| **4** | Very active    | Intense exercise, heavy physical work, multiple activity sessions. |
 
### Activity Tags

"What affected your activity today?"

1. `Planned workout` 🏋️‍♂️ _(positive)_
2. `Active commute` 🚶‍♂️ _(positive)_
3. `Outdoor time` 🌳 _(positive)_
4. `Extra steps` 👟 _(positive)_
5. `Sports/game` 🏀 _(positive)_
6. `Busy day` 📅 _(neutral — activity from errands/work)_
7. `Travel` ✈️ _(context — often limits activity)_
8. `Work from home` 🖥️ _(context — often sedentary)_
9. `Tired` 😴 _(negative barrier)_
10. `Sore/injury` 🤕 _(negative barrier)_
11. `Weather` 🌧️ _(negative barrier)_
12. `Lack of time` ⏳ _(negative barrier)_

### Note

Allow them to generate a daily note to go along this day's entry.

# Daily suggestion engine

Every day, we will generate 3 tips for the next day, that will use only the combination of answers from questionnaire (answers + tags).

// TODO Generate bunch of suggestions and make an algorithm that will spit out 3 suggestions for the next day. Those will just be displayed, there won't be an option for user to accept or reject them, it's a gentle guidance, and there are no checkmarks to mark completed. It's something to have in mind when you open the app the next day.
# Weekly goals engine

Whenever the Sunday report is done and the day is closed, we will take a look at previous week, what weight they reported throughout the days, how much the weight changed, and what food and activity levels were reported. Then we will generate two goals to fill out for that week. One would be the food goal, second one would be activity goal, but it has to be dosed. E.g. if they ate total of 28 levels last week (7+4=moderate), and they did minimum activity every day, but they lost -0.5 kg, we might suggest them the same. If they gained a bit of weight, we might want to increase their workout a bit, and keep the food the same. 

The output should be something like:
- Let's try to eat moderately this week (goal filled if food ate is 28 or less)
- Let's have 15 minutes of some light activity at least 5 times per week
  
Food goal should be given for whole week, to avoid them eating 5 days moderately and then overeating 2 days. We could combine it and say, let's try to eat moderately 5 days, and try to eat slighly less for 2 days in a week.

For workout goal, we can just give partial goals, e.g. perform light activity 3 times next week.