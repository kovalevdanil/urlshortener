import React, {useState} from 'react'

import './Home.css'
import {validURL} from "../../util/validator";
import {getShortenedUrl} from "../../api/requests";

const Home = (props) => {

    const [inputUrl, setInputUrl] = useState('')
    const [outputUrl, setOutputUrl] = useState('')

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
                .catch(console.log)
        }
    }

    const isUrlValid = validURL(inputUrl)
    debugger

    return <div className = 'container'>
        <div className='greets'>
            <h1>UrlShortener</h1>
            <p>Here you can shorten any url you want! Just paste a link and press the button</p>
        </div>
        <div className = 'converter'>
             <input className='converter__input' value = {inputUrl} onChange={onUrlChange} placeholder='Paste a link here'/>
             <button className = {'converter__convert-btn ' + (isUrlValid ? 'active' : '')} onClick = {onButtonClick}>>shorten></button>
             <input className = 'converter__output' value = {outputUrl} readOnly placeholder='Here will be shortened link'/>
        </div>
    </div>
}

export default Home