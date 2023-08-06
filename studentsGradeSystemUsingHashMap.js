class HashMap {
  constructor() {
    this.map = new Map();
  }

  calculateAverageMarksOfAllStudents(studentsData) {
    let sum = 0;
    if (studentsData) {
      for (let i = 0; i < studentsData.length; i++) {
        // Convert the marks string to a number using parseInt
        sum +=
          parseInt(studentsData[i].marks.English) +
          parseInt(studentsData[i].marks.Maths);
      }
      let avg = sum / studentsData.length;
      return avg;
    }
    return -1;
  }

  calculateTotalAndPercentageOfParticularStudent(studentData) {
    if (studentData && studentData.marks) {
      let totalMarks = 0;
      let numberOfSubjects = 0;

      for (const subject in studentData.marks) {
        if (studentData.marks.hasOwnProperty(subject)) {
          totalMarks += studentData.marks[subject];
          numberOfSubjects++;
        }
      }

      const percentage = (totalMarks / (numberOfSubjects * 100)) * 100;
      return { totalMarks, percentage };
    } else {
      return null; // Student not found or marks not available
    }
  }

  addStudentDetails() {
    const readline = require("readline");

    // Create an interface to read input from the command line
    const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout,
    });

    // Define a recursive function to handle input for each student
    const inputStudent = () => {
      console.log("\nMenu:");
      console.log("1. Add a new student");
      console.log("2. Print student details");
      console.log("3. Calculate Average of all Students marks");
      console.log(
        "4. Calculate Average and Percentage of particular Students marks"
      );
      console.log("5. Exit");

      rl.question("Enter your choice (1/2/3/4): ", (choice) => {
        switch (choice) {
          case "1":
            // Take user input for name
            rl.question("Enter your name: ", (name) => {
              // Take user input for age
              rl.question("Enter your age: ", (ageString) => {
                // Convert the age string to a number using parseInt
                let age = parseInt(ageString);

                // Check if the entered age is a valid number
                if (!isNaN(age)) {
                  // Create an object to store age and marks
                  let studentDetails = { age: age };

                  rl.question(
                    "Enter Student marks for English Subject: ",
                    (englishMarksString) => {
                      let englishMarks = parseInt(englishMarksString);

                      rl.question(
                        "Enter Student marks for Maths Subject: ",
                        (mathMarksString) => {
                          let mathMarks = parseInt(mathMarksString);

                          // Store the marks in the object
                          studentDetails.marks = {
                            English: englishMarks,
                            Maths: mathMarks,
                          };

                          // Store the student details in the Map
                          this.map.set(name, studentDetails);
                          console.log("Student added successfully!");

                          // Continue to the menu
                          inputStudent();
                        }
                      );
                    }
                  );
                } else {
                  console.log("Invalid age entered.");
                  // Continue to the menu
                  inputStudent();
                }
              });
            });
            break;
          case "2":
            this.printMap();
            // Continue to the menu
            inputStudent();
            break;
          case "3":
            const avg = this.calculateAverageMarksOfAllStudents(
              Array.from(this.map.values())
            );
            console.log(`Average of all Students marks: ${avg}`);
            // Continue to the menu
            inputStudent();
            break;
          case "4":
            rl.question("Enter Student name : ", (studentName) => {
              const studentDetails = this.map.get(studentName);
              const studentPercentageAndAverage =
                this.calculateTotalAndPercentageOfParticularStudent(
                  studentDetails
                );
              console.log(
                `Average of ${studentName} is : ${studentPercentageAndAverage.totalMarks} and percentage ${studentPercentageAndAverage.percentage}`
              );
              // Continue to the menu
              inputStudent();
            });
            break;
          case "5":
            rl.close();
            console.log("Exiting the program.");
            break;
          default:
            console.log("Invalid choice. Please try again.");
            // Continue to the menu
            inputStudent();
            break;
        }
      });
    };

    // Start input process
    inputStudent();
  }

  printMap() {
    console.log("\nStudent Details:");
    for (const [name, studentDetails] of this.map.entries()) {
      console.log(
        `Name: ${name}, Age: ${studentDetails.age}, Marks: English: ${studentDetails.marks.English}, Maths: ${studentDetails.marks.Maths}`
      );
    }
  }
}

const myMap = new HashMap();
myMap.addStudentDetails();
