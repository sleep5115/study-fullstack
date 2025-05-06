'use client'

import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {User} from "@/types/user";

const HomePage = () => {
    const [userId, setUserId] = useState<string>('');
    const [userData, setUserData] = useState<User | null>(null);
    const [error, setError] = useState<string>('');

    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setUserId(e.target.value);
    };

    const handleSubmit = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/user/${userId}`);
            setUserData(response.data);
            setError('');
        } catch (err) {
            console.error("There was an error fetching the data:", err);
            setError('User not found');
        }
    };

    return (
        <div>
            <h1>Welcome to the Next.js Frontend!</h1>

            <div>
                <input
                    type="text"
                    value={userId}
                    onChange={handleInputChange}
                    placeholder="Enter user ID"
                />
                <button onClick={handleSubmit}>Get User</button>
            </div>

            {error && <p style={{color: 'red'}}>{error}</p>} {/* 오류 메시지 출력 */}

            <div>
                {userData ? (
                    <div>
                        <p>User Name: {userData.userName}</p>
                        <p>User Email: {userData.userEmail}</p>
                    </div>
                ) : (
                    <p>No user data available</p>
                )}
            </div>
        </div>
    );
};

export default HomePage;