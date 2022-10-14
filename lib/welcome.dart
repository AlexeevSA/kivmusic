import 'dart:html';

import 'package:flutter/material.dart';

class Welcome extends StatefulWidget{
  const Welcome({Key? key}) : super(key: key);

  @override
  State<Welcome> createState()=> _WelcomeState();

}

class _WelcomeState extends State<Welcome>{
  @override
  Widget build(BuildContext context){
    return Scaffold(
      backgroundColor: Color.fromARGB(255, 0, 159, 162),
      body: SafeArea(
        child: Center(
          child: Column(mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SizedBox(height: 100,),
            Text(
              'medinow',
            style: TextStyle(fontWeight: FontWeight.bold, 
            fontFamily: 'Nunito',
            fontSize: 44,
            color: Colors.white),),
            SizedBox(height: 1,),
            Text(
              'Meditate With Us',
            style: TextStyle(fontWeight: FontWeight.normal,
            fontFamily: 'Nunito-Light',
            fontSize: 20, color: Colors.white),),
            SizedBox(height: 50,),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 25.0 ),
              child: Container(
                padding: EdgeInsets.all(13),
                decoration: BoxDecoration (color: Colors.white,
                borderRadius: BorderRadius.circular(25)),
                child: Center(
                  child: Text(
                    'Sign in with Apple',
                    style: TextStyle(
                      color: Colors.black,
                      fontFamily: 'Nunito-Lignt',
                      fontSize: 20
                    ),
                    ))
              ),
            ),
            SizedBox(height: 15,),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 25.0 ),
              child: Container(
                padding: EdgeInsets.all(13),
                decoration: BoxDecoration (color: Color.fromARGB(255, 205, 253, 254),
                borderRadius: BorderRadius.circular(25)),
                child: Center(
                  child: Text(
                    'Sign in with Email or Phone',
                    style: TextStyle(
                      color: Colors.black,
                      fontFamily: 'Nunito-Lignt',
                      fontSize: 20
                    ),
                    )),
              ),
            ),
            SizedBox(height: 15,),
            Text(
              'Continue with Google',
            style: TextStyle(fontWeight: FontWeight.normal,
            fontFamily: 'Nunito-Light',
            fontSize: 15, color: Colors.white),),
            SizedBox(height: 15,),
            Expanded(child: 
            Align(alignment: FractionalOffset.bottomCenter,
            child: Padding(
              padding: EdgeInsets.only(bottom: 10.0),
              child: Image.asset('assets/1.png', width: 350, height: 350,),
              ),)
            ),
          ]),
        ),
      ),
    );
  }
}