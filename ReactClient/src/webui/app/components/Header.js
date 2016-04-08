import React from 'react'
require("../../public/plain-mock.css")

const Header = ( { heading } ) => (
    <div id="masthead" className="frame">
      <h1>{heading}</h1>
    </div>
)

export default Header
