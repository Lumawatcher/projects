name = input('Choose a boy\'s name\n')
color = input('What is your favorite color?\n')
city = input('Choose any city in the USA\n')
fruit = input('Pick a fruit\n')
animal = input('Choose an animal you would see on safari\n')

print('Are you okay with these selections? {}, {}, {}, {}, {}'.format(name, color, city, fruit, animal))
confirm = input().lower().strip()
affirmative = ['yes', 'yep', 'sure', 'sure am', 'i guess']
if confirm in affirmative:
    print('You\'re a big fat homo')
    input()
else:
    print('Too bad, you\'re stuck with them')
    input()
    print('You\'re a big fat homo')
    input()
