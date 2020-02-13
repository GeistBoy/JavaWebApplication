import React, { Component } from "react";

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
      type: this.state.type,
      capacity: this.state.capacity,
      location: this.state.location,
      description: this.state.description,
      startTime: this.state.startTime,
      endTime: this.state.endTime
    };

    console.log(newActivity);
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
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Type"
                    name="type"
                    value={this.state.type}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Capacity"
                    name="capacity"
                    value={this.state.capacity}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Location"
                    name="location"
                    value={this.state.location}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Description"
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
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default AddActivity;
