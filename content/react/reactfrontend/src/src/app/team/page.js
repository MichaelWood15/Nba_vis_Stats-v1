"use client";

import Link from 'next/link';
import Navigation from '../navigation';
import styles from '../Styles/Player.module.css';
import React, {useState, useEffect} from 'react';
import axios from 'axios';
import PlayerCard from '../components/playerCard';

export default function Team(){

    const [inputValue, setInputValue] = useState('');
    const [data, setData] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        async function getStats() {
            if (inputValue) {
                try {
                    //console.log(inputValue); // Log the current input value
                    const response = await axios.get(`/api/v1/player?team=${inputValue}`);
                    setData(response.data);
                    setError(null);
                    console.log(response);
                } catch (error) {
                    console.log(error);
                    setError(error);
                    setData([]);
                }
            } else {
                setData([]);
            }
        }

        getStats();
    }, [inputValue]); // Dependency array, re-run effect when inputValue changes

    // Handle input change and update the state
    function handleChange(event) {
        setInputValue(event.target.value);
    }


    return(
        <main>
            <Navigation></Navigation>
            <section className={styles.container}>
            <input onChange={handleChange} className={styles.search} type='text' placeholder='Search A Player...'></input>
            </section>
            <div className={styles.playerCardsContainer}>
            {data.length > 0 ? (
                    data.map(player => (
                        <PlayerCard key={player.id} player={player} />
                    ))
                ) : (
                    <p>No players found.</p> // Display a message if no data is available
                )}
            </div>
        </main>
        
    );
}