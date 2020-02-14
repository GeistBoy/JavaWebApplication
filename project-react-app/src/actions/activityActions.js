import axios from "axios";
import {GET_ERRORS} from "./types";

export const createActivity = (activity, history) => async dispatch => {
    try {
        const res = await axios.post("http://localhost:8080/Activity", activity);
        history.push("/dashboard");
    } catch (error){
        dispatch({
            type: GET_ERRORS,
            payload: error.response.data
        })
        console.log(error.message);
    }
}
