'use strict'

// just playing around with callbacks

const myCallback = (answer) => {
  return 'got the answer: ' + answer
}

const start = (callback) => {
  console.log(callback('42'))
}

start(myCallback)
