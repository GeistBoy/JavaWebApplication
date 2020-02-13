import React from 'react'
import { Link } from 'react-router-dom'

const CreateButton = () => {
    return (
      <React.Fragment>
        <Link to="/addActivity" className="btn btn-lg btn-info">
          Create One
        </Link>
      </React.Fragment>
    );
}

export default CreateButton;