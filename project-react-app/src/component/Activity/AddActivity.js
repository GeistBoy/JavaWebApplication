import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import {createActivity} from "../../actions/activityActions"

class AddActivity extends Component {
  constructor() {
    super();

    this.state = {
      title: "",
      type: "",
      capacity: "",
      location: "",
      description: "",
      startTime: `${new Date().getFullYear()}-${`${new Date().getMonth() +
        1}`.padStart(2, 0)}-${`${new Date().getDate() + 1}`.padStart(
        2,
        0
      )}T${`${new Date().getHours()}`.padStart(
        2,
        0
      )}:${`${new Date().getMinutes()}`.padStart(2, 0)}`,
      endTime: `${new Date().getFullYear()}-${`${new Date().getMonth() +
        1}`.padStart(2, 0)}-${`${new Date().getDate() + 1}`.padStart(
        2,
        0
      )}T${`${new Date().getHours()+2}`.padStart(
        2,
        0
      )}:${`${new Date().getMinutes()}`.padStart(2, 0)}`
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({ [e.target.name] : e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newActivity = {
      title: this.state.title,
      // type: this.state.type,
      // capacity: this.state.capacity,
      location: this.state.location,
      // description: this.state.description,
      // startTime: this.state.startTime,
      // endTime: this.state.endTime
    };

    this.props.createActivity(newActivity, this.props.history);
  }

  render() {
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Create Activity form</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <h6>Title</h6>
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Activity Title"
                    name="title"
                    value={this.state.title}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <h6>Type of the Activity</h6>
                  <select className="form-control" value={this.state.type} onChange={this.onChange}>
                    <option value="0">Soccer</option>
                    <option value="1">Basketball</option>
                    <option value="2">Study</option>
                  </select>
                </div>
                <div className="form-group">
                  <h6>Capacity</h6>
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="What's the capacity (has to be number)"
                    name="capacity"
                    value={this.state.capacity}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <h6>Location</h6>
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Where?"
                    name="location"
                    value={this.state.location}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <h6>Description</h6>
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Any addtional information?"
                    name="description"
                    value={this.state.description}
                    onChange={this.onChange}
                  ></textarea>
                </div>
                <h6>Start Time</h6>
                <div className="form-group">
                  <input
                    type="datetime-local"
                    className="form-control form-control-lg"
                    name="startTime"
                    value={this.state.startTime}
                    onChange={this.onChange}
                  />
                </div>
                <h6>End Time</h6>
                <div className="form-group">
                  <input
                    type="datetime-local"
                    className="form-control form-control-lg"
                    name="endTime"
                    value={this.state.endTime}
                    onChange={this.onChange}
                  />
                </div>
                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                />
                <br></br>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddActivity.propTypes = {
  createActivity : PropTypes.func.isRequired,
  errors : PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  errors: state.errors
});

export default connect(null, { createActivity })(AddActivity);
