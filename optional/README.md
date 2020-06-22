# Optional
In this tutorial I will discuss about the [java.util.Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html), which was introduced in java 8.

To understand java.util.Optional fully we need to understand

- [What is Optional](./README.md#What-is-Optional ) 
- [Why to use Optional](./README.md#Why-to-use-Optional)
- [How to use Optional](./README.md#How-to-use-Optional)

	
**Note**: In all examples given below I am refering below files:

- [Student.java](./src/main/java/com/techgurukul/stream/optional/Student.java)
- [StudentDTO.java](./src/main/java/com/techgurukul/stream/optional/StudentDTO.java)
- [Teacher.java](./src/main/java/com/techgurukul/stream/optional/Teacher.java)

While writing this tutorial I used below technologies:
- Java 11.0.2
- junit-jupiter 5.6.2
	
### What is Optional 
As name implies, Optional gives an option to choose. In java terms its a class that contain a value which either be null or non-null.

### Why to use Optional
In java its very common to get NullPointerException and this exception triggered when some operation done on null reference. To overcome this problem java introduced **java.util.Optional** which basically contain the value whether it is null or non-null and provide methods which enforces the idea of ***null checking***.

> null checking: It forces user to check null before doing any other operation. Optional provide many methods which can be used for this like ifPresent, isEmpty. 

In simple terms Optional gives an alternative to remove NullPointerException as much as possible.

For more details about why to use Optional, please check [here](https://www.oracle.com/java/technologies/java8-optional.html).

### How to use Optional

 1. **Creating an Optional Object**:
 	
 	- ***Empty Optional***: Optional.empty() method creates an empty Optional with no/null value inside. In below code you can see     how to create an empty Integer Optional:
      ```java
      Optional<Integer> empty = Optional.empty();
      ```
      Generally, this is used as a return type from a method instead of null reference. For example:
    
      Before java 8:
      ```java
      public static StudentDTO toStudentDtoBeforeJava8(Student student) {
        if (student == null) {
          return null;
        }

        StudentDTO studentDTO = new StudentDTO();
        if (null != student.getName()) {
          studentDTO.setName(student.getName());
        }
        return studentDTO;
      }
      ```
      Since java 8:
      ```java
      public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {
        if (student == null) {
          return Optional.empty();
        }

        StudentDTO studentDTO = new StudentDTO();
        if (null != student.getName()) {
          studentDTO.setName(student.getName());
        }
        return Optional.of(studentDTO);
      }
      ```
      
    - **Optional with non-null value**: Optional.of(T value) method creates an Optional for non-null value, if you pass null then you will get NullPointerException. In below code you can see how to create a non-null Integer Optional:
      ```java
      Optional<Integer> nonEmpty = Optional.of(Integer.valueOf(2));
      ```
 	    
    - **Optional with null or non-null value**: Optional.ofNullable(T value) method creates an Optional for null and non-null values. 
    
      - When null passed to ofNullable method it creates an empty Optional 
        ```java
        Optional<String> emptyOptional = Optional.ofNullable(null);
        ```
      - When non-null passed to ofNullable method it creates non-null optional using Optional.of(T value) method. 
        ```java
        Optional<String> nonEmpty = Optional.ofNullable(Integer.valueOf(2));
        ```
      To check whether the optional contains value or not you can use **Optional.isPresent** or **Optional.isEmpty** methods. In below code you can see how to create a Optional for null or non-null Integer Optional.
      
    ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OptionalCreateTest.java).***

 2. **Get value from an Optional**: The simplest way to get non-null value from Optional is to use get() method. If you try to fetch value from an empty Optional or null value optional, then this method will throw NoSuchElementException.
    ```java
    @Test
    void test_get_OptionalValue() {

      Optional<String> emptyOptional = Optional.ofNullable(null);
      assertThrows(NoSuchElementException.class, () -> emptyOptional.get());

      Optional<String> nonEmptyOptionalByOfNullable = Optional.ofNullable("testOptional");
      assertTrue(nonEmptyOptionalByOfNullable.get().equals("testOptional"));

      Optional<String> nonEmptyOptionalByOf = Optional.of("testOptional");
      assertTrue(nonEmptyOptionalByOf.get().equals("testOptional"));

    }
    ```
    ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OptionalGetTest.java).***
    
 3. **Checking of value in Optional**: Optional class provided two methods to check whether the optional is empty or having some value.
 
    - **isPresent**: Optional.isPresent() return true for non-null optioanl otherwise false.
      ```java
      @Test
      void test_isPresent() {

        Optional<String> emptyOptional = Optional.ofNullable(null);
        assertFalse(emptyOptional.isPresent());//created without value so value is not present

        Optional<String> nonEmptyOptional = Optional.ofNullable("testOptional");
        assertTrue(nonEmptyOptional.isPresent());//created with value so value is present

      }
      ```
    - **isEmpty**: Optional.isEmpty() return true for null/empty optional otherwise true.
      ```java
      @Test
      void test_isEmpty() {

        Optional<String> emptyOptional = Optional.ofNullable(null);
        assertTrue(emptyOptional.isEmpty());//created without value so it's empty

        Optional<String> nonEmptyOptional = Optional.ofNullable("testOptional");
        assertFalse(nonEmptyOptional.isEmpty());//created with value so it's not empty

      }
      ```
      ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OptionalValidationTest.java).***
      
 4. **Other helper methods**: Optional class provides many other helper methods which can be used with optional. So, let’s check one by one all the methods with examples:
    
    - **ifPresent with action**: Optional class have ifPresent overloaded methods which perform the given action if the value is present else does nothing.
      
      Syntax:
      ```java
      public void ifPresent(Consumer<? super T> action)
      ```
      Example:
      Before java 8:
      ```java
      public static StudentDTO toStudentDtoBeforeJava8(Student student) {
        if (student == null) {
          return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        if (null != student.getName()) {
          studentDTO.setName(student.getName());
        }
        return studentDTO;
      }
      ```
      Since java 8:
      ```java
      public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {

        if (student == null) {
          return Optional.empty();
        }
        StudentDTO studentDTO = new StudentDTO();
        Optional.ofNullable(student.getName()).ifPresent(studentDTO::setName);
        return Optional.of(studentDTO);
      }
      ```
      ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/IfPresentUtilTest.java).***
      
    - **ifPresentOrElse with action**: This method was added in java 9, it is similar to **ifPresent with action**, the only different thing is that you can also mention action which should be performs when optional is empty or having null value.
    
      Syntax:
      ```java
      public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)
      ```
      Example:
      
      Before java 8:
      ```java
      public static StudentDTO toStudentDtoBeforeJava8(Student student) {
        
        if (student == null) {
          return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        if (null != student.getName()) {
          studentDTO.setName(student.getName());
        } else {
          studentDTO.setName("test");
        }
        return studentDTO;
      }
      ```
      Since java 9:
      ```java
      public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {

        if (student == null) {
          return Optional.empty();
        }
        StudentDTO studentDTO = new StudentDTO();
        Optional.ofNullable(student.getName()).ifPresentOrElse(studentDTO::setName, () -> studentDTO.setName("test"));
        return Optional.of(studentDTO);
      }
      ```
      
      ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/IfPresentOrElseUtilTest.java).***

    - **orElse**: This method return the value if it is non-null otherwise return the value specified in orElse(T other).
    
      Syntax:
      ```java
       public T orElse(T other)
      ```
      Example:
      
      Before java 8:
      ```java
      public static StudentDTO toStudentDtoBeforeJava8(Student student) {
        if (student == null) {
          return null;
        }

        StudentDTO studentDTO = new StudentDTO();
        if (null != student.getName()) {
          studentDTO.setName(student.getName());
        } else {
          studentDTO.setName("test");
        }
        return studentDTO;
      }
      ```
      Since java 8:
      ```java
      public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {
        if (student == null) {
          return Optional.empty();
        }

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(Optional.ofNullable(student.getName()).orElse("test"));
        return Optional.of(studentDTO);
	    }
      ```
      ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OrElseUtilTest.java).***
      
     - **orElseGet**: It is same as [orElse](./README.md#orElse), the only difference is that if optional is null/empty then return value will be produced by the [supplying](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html) function.
     
       In simple terms if optional is empty then the get method from implementation of the [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html) interface will be executed and will return the value.
     
       Syntax:
          ```java
          public T orElseGet(Supplier<? extends T> supplier)
          ```
       Example:
       
       Before java 8:
       ```java
       public static StudentDTO toStudentDtoBeforeJava8(Student student) {
        if (student == null) {
          return null;
        }

        StudentDTO studentDTO = new StudentDTO();
        if (null != student.getName()) {
          studentDTO.setName(student.getName());
        } else {
          studentDTO.setName("test");
        }
        return studentDTO;
       }
       ```
       Since java 8:
       ```java
       public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {
        if (student == null) {
          return Optional.empty();
        }

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(Optional.ofNullable(student.getName()).orElseGet(() -> "test"));
        return Optional.of(studentDTO);
	     }
       ```
     
       ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OrElseGetUtilTest.java).***
      
       ***Check the [difference between orElse and OrElseGet](./README.md#difference-between-orElse-and-OrElseGet)***.
      
      
     - **orElseThrow**: This method was added in java 10. This method return the value if it is non-null otherwise throw NoSuchElementException.
     
       Syntax: 
       ```java
       public T orElseThrow()
       ```
       Example:
       
       Before java 8:
       ```java
        public static StudentDTO toStudentDtoBeforeJava8(Student student) {

          if (student == null) {
            return null;
          }

          StudentDTO studentDTO = new StudentDTO();
          if (null != student.getGender()) {
            studentDTO.setGender(student.getGender());
          } else {
            throw new NoSuchElementException("Gender can not be empty.");
          }
          return studentDTO;
        }
       ```
       
       Since java 10
       ```java
        public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {

          if (student == null) {
            return Optional.empty();
          }

          StudentDTO studentDTO = new StudentDTO();
          studentDTO.setGender(Optional.ofNullable(student.getGender()).orElseThrow());
          return Optional.of(studentDTO);
	      }
       ```
       
       ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OrElseThrowUtilTest.java).***

     - **orElseThrow with custom exception**: This method return the value if it is non-null otherwise throw custom exception.
     
       Syntax: 
       ```java
       public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X
       ```
       Example:
       
       Before java 8:
       ```java
       public static StudentDTO toStudentDtoBeforeJava8(Student student) {

          if (student == null) {
            return null;
          }

          StudentDTO studentDTO = new StudentDTO();
          if (null != student.getGender()) {
            studentDTO.setGender(student.getGender());
          } else {
            throw new RuntimeException("Gender can not be empty.")
          }
          return studentDTO;
        }
       ```
       Since java 8:
       ```java
       public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {

          if (student == null) {
            return Optional.empty();
          }

          StudentDTO studentDTO = new StudentDTO();
          studentDTO.setGender(Optional.ofNullable(student.getGender()).orElseThrow(() -> new RuntimeException("Gender can not be empty.")));
          return Optional.of(studentDTO);
	      }
       ```
       ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OrElseThrowCustomeExceptionUtilTest.java).***
       
       
     - **or**: This method was added in java 9. This method return the current Optional if it is non-null otherwise returns an Optional produced by the supplying function.
       
       Syntax:
       ```java
       public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)
       ```
       Example:
       ```java
        public static Optional<Student> getStudent(Student student) {
          Student dfaultStudentObj = new Student("defaultName", 001, "defualtEmail@email.com")
		      return Optional.ofNullable(student).or(() -> Optional.of(dfaultStudentObj));
	      }
       ```
       In above example you can see, if student object is null then this methods returns dfaultStudentObj optional.
       
       ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OrUtilTest.java).***
       
     - **filter**: If a value is present, and the value matches the given predicate/condition then returns current Optional otherwise empty Optional. 
       
       Syntax:
       ```java
       public Optional<T> filter(Predicate<? super T> predicate)
       ```
       Example: 
       ```java
       @Test
	     void test_filter() {
         Student stu = new Student("test", 123, "test@email.com");
         Optional<Student> studentOptional = Optional.of(stu);
         Optional<Student> filteredStudentOptional = studentOptional.filter(st -> "test".equals(st.getName()));
         assertTrue(filteredStudentOptional.equals(studentOptional));
         assertTrue(filteredStudentOptional.isPresent());
       }
       ```
       
       ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OptionalFilterTest.java)*** for more filter examples.
       
     - **map**: If a value is not present returns an empty Optional otherwise apply the mapping function to convert optional value to different type and wrap the result in Optional using ofNullable and returns the same.
       
       Syntax:
       ```java
       public <U> Optional<U> map(Function<? super T, ? extends U> mapper) 
       ```
       Example: 
       ```java
       @Test
	     void test_filter() {
         Student stu = new Student("test", 123, "test@email.com");
         Optional<Student> studentOptional = Optional.of(stu);
         Optional<String> nameOptional = studentOptional.map(Student::getName);
		     assertFalse(nameOptional.isEmpty());
         assertTrue(nameOptional.isPresent());
         assertTrue(nameOptional.get().equals(stu.getName()));
       }
       ```
       
       ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OptionalMapTest.java)*** for more map examples.
       
     - **flatMap**: It is same as **map**, except that it won't wrap the result in Optional. 
     
       **Note**: The mapped value should also be an optional
       
       Syntax:
       ```java
       public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)
       ```
       Example: 
       ```java
       @Test
	     void test_filter() {
         Teacher nullTeacher = Optional.of(new Teacher("tTest", "Computer"));
		     Optional<Teacher> nullTeacherOptional = Optional.ofNullable(nullTeacher);
         Optional<String> depFlatMap = teacher.flatMap(Teacher::getDepartment);
		     assertTrue(depFlatMap.get().equals("Computer"));
       }
       ```
       
       ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OptionalFlatMapTest.java)*** for more flatMap examples.
       
       
     - **stream**: This method was added in java 9. If a value is present, returns a [Stream](https://docs.oracle.com/javase/8/docs/api/?java/util/stream/Stream.html) containing only that value, otherwise returns an empty [Stream](https://docs.oracle.com/javase/8/docs/api/?java/util/stream/Stream.html).
       
       Syntax:
       ```java
       public Stream<T> stream() 
       ```
       Example: 
       ```java
       @Test
	     void test_stream() {
         Optional<Integer> integerOptional = Optional.of(Integer.valueOf(2));
         Stream<Integer> integerStream = integerOptional.stream();
		     assertTrue(integerStream.findFirst().isPresent());
       }
       ```
       
       ***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OptioanStreamTest.java)***.
       
### Difference between orElse and OrElseGet:

When Optional.orElse method used, this execute statement defined in orElse part as well, it doesn’t matter whether the optional is empty or not. It means if the orElse method have some complex or transaction logic which should be executed only when optional is empty, will always be executed. So ***use orElse method with care else you will get unwanted results in your code***.

When Optional.orElseGet method used, this execute statement defined in orElseGet only if optional is empty. By default, every time use orElseGet method unless there is specific requirement (like in case where return object which is already defined.) to use orElse.

***Check source code [here](./src/test/java/com/techgurukul/stream/optional/OrElseVsOrElseGetUtilTest.java)*** to see the impact of using orElse method.
       
