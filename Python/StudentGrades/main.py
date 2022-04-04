# student_grades contains scores (out of 100) for 5 assignments
student_grades = {
    'Andrew': [56, 79, 90, 22, 50],
    'Nisreen': [88, 62, 68, 75, 78],
    'Alan': [95, 88, 92, 85, 85],
    'Chang': [76, 88, 85, 82, 90],
    'Tricia': [99, 92, 95, 89, 99]
}
#finding highest score sum
best_student = ''
best = int()
for student, grades in student_grades.items():
    if sum(grades) > best:
        best_student = student
        best = sum(grades)
print('Highest grade: {}, {} points'.format(best_student, best))

#finding avg assigment grade
assignment_averages = []
# n is iterable for while loop
n = 0
while n <= 4:
    current_avg = 0
    for score in student_grades.values():
        current_avg += score[n]
    current_avg /= 5
    assignment_averages.append(current_avg)
    n += 1
n = 0
while n <= 4:
    print('Assignment no. {} has an average score of {}'.format((n+1), assignment_averages[n]))
    n += 1

#creating a curve, best is now 100%, all other students graded under that curve
curved_grades = {}
for student, grades in student_grades.items():
    curved_grade = int((sum(grades)/best)*100)
    curved_grades.update({student: curved_grade})

print(curved_grades)