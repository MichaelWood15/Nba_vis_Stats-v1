"use client";

import styles from "./Styles/Navigation.module.css";
import Link from 'next/link';

export default function Navigation(){

    return(
        <main className={styles.main}>
            <div className={styles.head}>
                <Link href="/" className={styles.title} style={{textDecoration: 'none'}} >NBA VIS STATS</Link>
                <section className={styles.buttonContainer}>
                    <Link href="/player" className={styles.buttonNav} style={{textDecoration: 'none'}}>Player</Link>
                    <Link href="/team" className={styles.buttonNav} style={{textDecoration: 'none'}}>Team</Link>
                </section>
            </div>
        </main>
    );
    
}