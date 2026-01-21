package com.mastercoding.retrofitdemoapp

// if your JSON response starts with []
// you need to create a wrapper class
// that extends 'ArrayList'.
class CompaniesList:ArrayList<Company>() {

}