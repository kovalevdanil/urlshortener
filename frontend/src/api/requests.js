import {API_BASE_URL} from "../constants/contsants";

export const getShortenedUrl = (url) => {
    return fetch(`${API_BASE_URL}/shorten?link=${encodeURI(url)}`, {
        method: 'GET'
    }).then(resp => resp.json())

}
