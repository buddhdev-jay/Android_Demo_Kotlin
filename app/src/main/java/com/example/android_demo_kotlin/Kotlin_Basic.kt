package com.example.android_demo_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.ArrayList

class Kotlin_Basic : AppCompatActivity() {

    lateinit var late_name: String

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_basic)
        //Data Types
        //Number Data Type
        val int1: Int = 123
        Log.i("Data Types", "int$int1")
        val int2: Int? = null
        Log.i("Data Types", "int Nullable " + int2.toString())
        val float1: Float = 223.5F
        Log.i("Data Types", "Float$float1")
        val long1: Long = 223L
        Log.i("Data Types", "long1$long1")

        //Character Data type
        val value1: Char
        value1 = 'A'
        Log.i("Data Types", "Character $value1")

        //Boolean Data type
        val flag = true
        Log.i("Data Types", "Boolean $flag")

        //Array
        val array1 = arrayOf(1, 2, 3, 4, 5)
        Log.i("Data Types", "Array $array1")

        //String
        val text1 = "Hello"
        Log.i("Data Types", "String $text1")
        //Raw String
        val text2 =
            """  
             Welcome   
                 To  
           kotlin Basic 
                """
        Log.i("Data Types", "Raw String $text1")
        var name2 = "Jay Buddhdev"
        var name3 = name2.substring(0, 2)

        //Type Converstion
        val long2: Long = int1.toLong()
        Log.i("Type Converstion", "To Long Type $long2")

        //Operator
        //Arithmetic Operator
        var a = 50;
        var b = 10;
        Log.i("Arithmetic Operator", (a + b).toString())
        Log.i("Arithmetic Operator", (a - b).toString())
        Log.i("Arithmetic Operator", (a * b).toString())
        Log.i("Arithmetic Operator", (a / b).toString())
        Log.i("Arithmetic Operator", (a % b).toString())

        //Relation Operator
        Log.i("Relation Operator", (a > b).toString())
        Log.i("Relation Operator", (a < b).toString())
        Log.i("Relation Operator", (a >= b).toString())
        Log.i("Relation Operator", (a <= b).toString())
        Log.i("Relation Operator", (a == b).toString())
        Log.i("Relation Operator", (a != b).toString())

        //Unary Operator
        Log.i("Unary Operator", (a++).toString())
        Log.i("Unary Operator", (a--).toString())
        Log.i("Unary Operator", (!flag).toString())

        //If Expression
        if (a > b) {
            Log.i("If Expression", "a is greater than b")
        }

        //If Else Expression
        if (a < b) {
            Log.i("If Else Expression", "If Block")
        } else {
            Log.i("If Else Expression", "Else Block")
        }

        //if-else if-else Ladder Expression
        if (a > 0) {
            Log.i("if_else if_else Ladder Expression", "num is positive")
        } else if (a < 0) {
            Log.i("if_else if_else Ladder Expression", "num is negative")
        } else {
            Log.i("if_else if_else Ladder Expression", "num is zero")
        }

        //When Expression
        var number = 50
        when (number) {
            50 -> Log.i("When Expression", "fifty")
            2 -> Log.i("When Expression", "two")
            53 -> Log.i("When Expression", "fifty three")
            4 -> Log.i("When Expression", "four")
            55 -> Log.i("When Expression", "fifty five")
            else -> Log.i("When Expression", "invalid")
        }

        //When Expression with rang
        when (number) {
            in 1..50 -> Log.i("When Expression with rang", "1 to 50")
            in 50..100 -> Log.i("When Expression with rang", "50 to 100")
            else -> Log.i("When Expression with rang", "invalid")
        }

        //For loop
        for (item in array1) {
            Log.i("For loop", item.toString())
        }

        //For with range
        for (i in 1..5) {
            Log.i("For with Range", i.toString())
        }

        //  While loop
        var i = 10
        while (i < number) {

            Log.i(" While loop", i.toString())
            i++
        }

        //Do While loop
        i = 10
        do {
            Log.i(" Do While loop", i.toString())
            i++
        } while (i < number);

        //Break statement
        for (i in 1..5) {

            if (i == 3) {
                Log.i(" Break Statement", "if i == 3 then break the loop")
                break;
            }
        }

        //Labled Break statement
        loop@ for (i in 1..3) {
            for (j in 1..3) {

                if (i == 2)
                    Log.i(" Labled Break Statement", "if i == 2 then break the outer loop")
                break@loop
            }
        }

        // Continue
        for (i in 1..5) {

            if (i == 3) {
                continue
            }
            Log.i(" Continue Statement", "if i == 3 then Continue loop")
        }

        //Functions
        fun sum(number1: Int, number2: Int): Int {
            val add = number1 + number2
            return add
        }

        val result = sum(5, 6)
        Log.i(" User Define function with paramenter and return type", result.toString())

        //Default Argument and named argument in Function
        fun run(num: Int = 5, latter: Char = 'x') {
            Log.i(
                " Default Argument and named argument in Function",
                "parameter in function definition $num and $latter"
            )
        }
        run(latter = 'a')

        //Lamda Function
        val sum1 = { a: Int, b: Int -> a + b }
        val result1 = sum1(2, 3)
        Log.i(" Lamda Function", result1.toString())

        //Higher order Function
        fun add(a: Double, b: Double): Double {
            return a + b;
        }

        fun HigherOrderFunction(a: Double, b: Double, fn: (Double, Double) -> Double): Double {
            return fn(a, b);
        }

        val output = HigherOrderFunction(2.0, 3.0, ::add)
        Log.i(" HigherOrderFunction", output.toString())

        //Smart cast for null Safe
        var string: String? = "Hello!"
        if (string != null) {
            Log.i(" Smart cast for null Safe", string.length.toString())

        }

        //as? Operator for null safe
        val location: Any = "Kotlin"
        val safeInt: Int? = location as? Int
        Log.i("as? Operator for null safe ", safeInt.toString())

        //Class and Init Block
        val myclass = myClass("ABC", 123)
        Log.i("name from myClass ", "Name = ${myclass.e_name}")
        Log.i("id from myClass ", "Id = ${myclass.e_id}")

        //Inheritance
        val myclass1 = Derived()
        myclass1.foo()
        Log.i("Inheritance ", myclass1.x.toString())

        //Sealed Class
        fun eval(e: Shape) =
            when (e) {
                is Shape.Circle -> Log.i("Sealed Class ", "Circle")
                is Shape.Square -> Log.i("Sealed Class ", "Square")
                is Shape.Rectangle -> Log.i("Sealed Class ", "Rectangle")

            }

        var circle = Shape.Circle(5.0f)
        var square = Shape.Square(5)
        var rectangle = Shape.Rectangle(4, 5)

        eval(circle)
        eval(square)
        eval(rectangle)

        //Data Class
        val u = User("jay", 101, "mymail@mail.com")
        Log.i("Data Class ", u.toString())

        //Extension Function
        val student = Student()
        val excellentStatus = student.isExcellent(95)
        Log.i("Extension Function ", excellentStatus.toString())

        //lateinit varable
        late_name = "abc"
        Log.i("Extension Function ", late_name.toString())

        //Lazy
        val student1: Student by lazy {
            Log.i("Lazy initialization ", "initialization by Lazy Keyword")
            Student()
        }

        //Collections
        //listOf()
        var list = listOf<Int>(1, 2, 3, 4)
        for (element in list) {
            Log.i("listOf()", element.toString())
        }
        Log.i("Functions of listOf()", list.get(0).toString())
        Log.i("Functions of listOf()", list.indexOf(2).toString())
        Log.i("Functions of listOf()", list.size.toString())
        Log.i("Functions of listOf()", list.contains(3).toString())
        Log.i("Functions of listOf()", list.isEmpty().toString())

        //ArrayList
        var arrayList = ArrayList<String>()
        arrayList.add("abc")
        arrayList.add("xyz")
        arrayList.add("pqr")
        Log.i("Array List Function", arrayList.get(2))
        arrayList.add("abc")
        Log.i("Array List Function LastIndexOf", arrayList.lastIndexOf("abc").toString())

        //Map
        val myMap = mapOf<Int, String>(1 to "abc", 4 to "pqr", 3 to "xyz")
        for (key in myMap.keys) {
            Log.i("Map", myMap[key].toString())
        }

        //HashMap
        val hashMap: HashMap<Int, String> = HashMap<Int, String>() //define empty hashmap
        hashMap.put(1, "abc")
        hashMap.put(3, "pqr")
        hashMap.put(4, "xyz")
        for (key in hashMap.keys) {
            Log.i("HashMap", hashMap[key].toString())
        }

        //Set
        val mySet: Set<Any> = setOf(2, 6, 4, 29, 4, 5, "abc", "xyz")
        for (element in mySet) {
            Log.i("Set", element.toString())
        }

    }

    class myClass(name: String, id: Int) {
        val e_name: String
        val e_id: Int

        init {
            e_name = name
            e_id = id
        }
    }

    open class Base {
        var x = 10
    }

    class Derived : Base() {
        fun foo() {
            x++
        }
    }

    sealed class Shape {
        class Circle(var radius: Float) : Shape()
        class Square(var length: Int) : Shape()
        class Rectangle(var length: Int, var breadth: Int) : Shape()

    }

    data class User(var name: String, var id: Int, var email: String)

    class Student {
        fun isPassed(mark: Int): Boolean {
            return mark > 40
        }
    }

    fun Student.isExcellent(mark: Int): Boolean {
        return mark > 90
    }
}

