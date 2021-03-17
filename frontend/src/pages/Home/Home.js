import React, {useState} from 'react'

import './Home.css'

import {validURL} from "../../util/validator";
import {getShortenedUrl} from "../../api/requests";
import {useToasts} from "react-toast-notifications";

const Home = (props) => {

    const [inputUrl, setInputUrl] = useState('')
    const [outputUrl, setOutputUrl] = useState('')
    const {addToast} = useToasts()

    const onUrlChange = (e) => {
        e.preventDefault()
        setInputUrl(e.target.value)
    }

    const onButtonClick = (e) => {
        e.preventDefault()
        if (validURL(inputUrl)){
            getShortenedUrl(inputUrl)
                .then(response => {
                    setOutputUrl(response.fullShortened)
                })
                .catch(error => {
                    addToast('Unable to shorten your link :(', {
                        appearance: 'error',
                        autoDismiss: true
                    })
                })
        }
    }

    const isUrlValid = validURL(inputUrl)

    return <div className = 'container'>
        <div className='greets'>
            <h1>UrlShortener</h1>
            <p>Here you can shorten any url you want! Just paste a link and press the button</p>
        </div>
        <div className = 'converter'>
             <input className='converter__input' value = {inputUrl} onChange={onUrlChange} placeholder='Paste a link here' autoComplete="off" autoCapitalize="off" autoCorrect="off"/>
             <button className = {'converter__convert-btn ' + (isUrlValid ? 'active' : '')} onClick = {onButtonClick}>>shorten></button>
             <input className = 'converter__output' value = {outputUrl} readOnly placeholder='Here will be shortened link'/>
        </div>
    </div>
}

export default Home