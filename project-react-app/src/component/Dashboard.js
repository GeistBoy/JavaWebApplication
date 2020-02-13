import React, { Component } from "react";
import CreateButton from "./Activity/CreateButton";
import ActivityItem from "./Activity/ActivityItem";

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Activities</h1>
              <br />
              <CreateButton />
              <br />
              <hr />
              <ActivityItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;
