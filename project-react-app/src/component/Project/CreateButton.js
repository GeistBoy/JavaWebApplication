import React from 'react'
import { Link } from 'react-router-dom'

const CreateButton = () => {
    return (
      <React.Fragment>
        <Link to="/addProject" className="btn btn-lg btn-info">
          Create a meeting
        </Link>
      </React.Fragment>
    );
}

export default CreateButton;