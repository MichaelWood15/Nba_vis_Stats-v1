"use client";

import Navigation from "./navigation";
import styles from "./Styles/page.module.css";
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Link from 'next/link';


export default function Page() {


    return (
        <main>
            <Navigation></Navigation>
            <h1>home</h1>
        </main>
    );
}