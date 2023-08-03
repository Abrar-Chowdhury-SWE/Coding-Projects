Refer to the Classroom file

A simulation of a classroom with students standing in line and taking seats in the classroom. The students are represented as objects of the Student class, and their positions in the classroom are represented using a 2D array called studentsSitting. The availability of seats in the classroom is represented using another 2D array called seatingLocation.

The Classroom class contains several methods to perform different actions in the simulation, including:

enterClassroom(String filename): This method reads student information from an input file and inserts them into the studentsInLine singly linked list in alphabetical order.

setupSeats(String seatingChart): This method reads seating availability from an input file and initializes the seatingLocation and studentsSitting 2D arrays.

seatStudents(): This method simulates students taking their seats in the classroom based on the seating availability. It removes students from studentsInLine and places them in the studentsSitting array according to the available seats.

insertMusicalChairs(): This method removes students from their seats in the classroom and adds them to the musicalChairs circular linked list. The method traverses the studentsSitting array row-wise, removing students one by one and inserting them into musicalChairs.

moveStudentFromChairsToLine(int size): This method removes a random student from the musicalChairs circular linked list and inserts that student into the studentsInLine singly linked list in ascending order by height.

eliminateLosingStudents(): This method repeatedly removes students from the musicalChairs circular linked list until there is only one student left (the winner). The eliminated students are inserted back into the studentsInLine singly linked list in ascending order by height.

seatMusicalChairsWinner(): This method seats the winner of the musical chairs game back in the classroom. If there is no winner or more than one student in musicalChairs, it does nothing.

playMusicalChairs(): This method represents the complete game of musical chairs. It eliminates losing students, seats the winner, and seats the remaining students back in the classroom.

The SNode class is used to create a singly linked list of students for the studentsInLine list and a circular linked list for the musicalChairs list.

Overall, this code represents a simulation of a classroom activity where students stand in line, take their seats, and play a game of musical chairs. The code uses different data structures to keep track of the students' positions and manage the classroom activity.