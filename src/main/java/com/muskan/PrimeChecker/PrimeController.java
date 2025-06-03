package com.muskan.PrimeChecker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class PrimeController {
    /*
     * GET /isprime?number=<value>
     * - If 'number' is missing → 400 BAD REQUEST with {"error": "..."}.
     * - If 'number' is not an integer → 400 BAD REQUEST.
     * - If 'number' < 0 → 400 BAD REQUEST.
     * - Otherwise → 200 OK with {"number": <n>, "isPrime": <true|false>}.
     */
    @GetMapping("/isPrime")
    public ResponseEntity<?> isPrimeEndpoint(@RequestParam(name = "number", required = false) String numStr) {
        // 1. Check presence
        if (numStr == null) {
            Map<String, String> err = Collections.singletonMap(
                    "error", "Missing required query parameter 'number'.");
            return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        }

        // 2. Parse to integer
        int n;
        try {
            // Reject decimal or non-numeric
            if (numStr.contains(".")) {
                throw new NumberFormatException();
            }
            n = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            Map<String, String> err = Collections.singletonMap(
                    "error", "'number' must be an integer. Received: " + numStr);
            return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        }

        // 3. Non-negative check
        if (n < 0) {
            Map<String, String> err = Collections.singletonMap(
                    "error", "'number' must be a non-negative integer.");
            return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        }

        // 4. Compute primality
        boolean result = isPrime(n);

        // 5. Build and return response
        PrimeModel response = new PrimeModel(n, result);
        return ResponseEntity.ok(response);
    }

    /*
     * Helper method to check if n is prime.
     * - n ≤ 1 → false
     * - n ≤ 3 → true (2 and 3 are prime)
     * - loop from i = 2 to sqrt(n) and check if n is divisible by i
     * - if n is divisible by i, then n is not prime
     * - if n is not divisible by i, then n is prime
     */
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
