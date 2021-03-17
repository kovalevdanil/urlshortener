import {API_BASE_URL} from "../constants/contsants";

export const getShortenedUrl = (url) => {
    return fetch(`${API_BASE_URL}/shorten?link=${encodeURI(url)}`, {
        method: 'GET'
    }).then(response => {
        if (!response.ok){
            throw new Error(response.statusText)
        }
        return response.json();
    })

}
